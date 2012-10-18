package com.soyomaker.message.handlers.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soyomaker.config.Config;
import com.soyomaker.lang.GameObject;
import com.soyomaker.model.User;
import com.soyomaker.net.AbHandler;
import com.soyomaker.net.UserSession;
import com.soyomaker.net.UserSessionManager;
import com.soyomaker.service.UserService;

@Component("loginHandler")
public class LoginHandler extends AbHandler {

	@Autowired
	private UserService userService;

	@Autowired
	private UserSessionManager userSessionManager;

	@Override
	public void handleMessage(UserSession session, GameObject msg) {
		String username = msg.getString("username");
		String password = msg.getString("password");
		// (1)检查包是否完整
		if (username == null || password == null) {
			return;
		}
		// (2)取用户名为 userName 的帐户
		User user = userService.findByUsername(username);
		if (user == null) {
			this.sendMessage(session, msg, false, "帐号不存在");
			return;
		}
		// (3)验证
		if (Config.isDebug() == false) {
			if (!user.getPassword().equals(password)) {
				this.sendMessage(session, msg, false, "密码不正确");
				return;
			}
		}
		// (4)登录成功
		session.setUser(user);
		userSessionManager.putUserSession(user.getId(), session);
		GameObject msgSent = this.buildPackage(msg, true, "登录成功");
		msgSent.putLong("userId", user.getId());
		netTransceiver.sendMessage(session, msgSent);
	}

}