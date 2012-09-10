package com.soyomaker.handlers.chat;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soyomaker.lang.GameObject;
import com.soyomaker.model.Player;
import com.soyomaker.net.AbHandler;
import com.soyomaker.net.UserSession;
import com.soyomaker.net.UserSessionManager;

@Component("chatHandler")
public class ChatHandler extends AbHandler {

	@Autowired
	private UserSessionManager userSessionManager;

	@Override
	public void handleMessage(UserSession session, GameObject msg) {
		String content = msg.getString("content");
		Player player = session.getUser().getPlayer();
		GameObject msgSent = this.buildPackage(msg.getType());
		msgSent.putInt("playerId", player.getId());
		msgSent.putString("playerName", player.getName());
		msgSent.putString("content", content);
		Collection<UserSession> userSessions = userSessionManager
				.getAllUserSession();
		for (UserSession userSession : userSessions) {
			netTransceiver.sendMessage(userSession, msgSent);
		}
	}

}
