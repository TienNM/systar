package com.soyomaker.message.handlers.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soyomaker.lang.GameObject;
import com.soyomaker.net.AbHandler;
import com.soyomaker.net.UserSession;
import com.soyomaker.net.UserSessionManager;

@Component("messagePushHandler")
public class MessagePushHandler extends AbHandler {

	@Autowired
	private UserSessionManager userSessionManager;
	
	

	@Override
	public void handleMessage(UserSession session, GameObject msg) {
		
		/*
		GameObject pushMessageObject=new GameObject();
		pushMessageObject.setType(Protocol.PUSH_MESSAGE);
		pushMessageObject.putString("title", value);
		pushMessageObject.putString("content", player.getName());
		pushMessageObject.putString("date", content);
		*/
		
//		//获得聊天信息的序列号
//		int sn = msg.getInt(SN_KEY);
//		String content = msg.getString("content");
//		Player player = session.getUser().getPlayer();
//		GameObject msgSent = new GameObject(msg.getType());
//		msgSent.putInt("playerId", player.getId());
//		msgSent.putString("playerName", player.getName());
//		msgSent.putString("content", content);
//		Collection<UserSession> userSessions = userSessionManager
//				.getAllUserSession();
//		for (UserSession userSession : userSessions) {
//			if (userSession.equals(session)) {
//				msgSent.putInt(SN_KEY, sn);
//			} else {
//				msgSent.remove(SN_KEY);
//			}
//			netTransceiver.sendMessage(userSession, msgSent);
//		}
	}
	
	/**
	 * 根据收到的包构造回复包，初始化回复包的序列号和协议ID
	 * 
	 * @param msgReceived
	 *            收到的包
	 */
	public GameObject buildResponsePackage(GameObject msgReceived) {
		GameObject msgSent = new GameObject();
		msgSent.setType(msgReceived.getType());
		msgSent.putInt(SN_KEY, msgReceived.getInt(SN_KEY));
		return msgSent;
	}


}
