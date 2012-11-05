package com.soyomaker.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soyomaker.lang.GameObject;
import com.soyomaker.net.NetTransceiver;
import com.soyomaker.net.session.UserSession;

/**
 * 此类模拟客户端发包，触发服务器响应，达到push的目的
 * 
 * @author wp_g4
 * 
 */

@Component("messageSender")
public class MessageSender {

	private static final String PROTOCOL_ID_UPDATE_NPC_STATUS = "106001";

	@Autowired
	protected NetTransceiver netTransceiver;

	/**
	 * 发送NPC状态信息
	 * 
	 * @param session
	 */
	public void updateNPCStatus(UserSession session) {
		netTransceiver.dispatchMessage(session, new GameObject(
				PROTOCOL_ID_UPDATE_NPC_STATUS));
	}

	/**
	 * 发送公告
	 */
	public void sendNotice() {
		// TODO UserSession 为空会异常
		netTransceiver.dispatchMessage(null, new GameObject(
				PROTOCOL_ID_UPDATE_NPC_STATUS));
	}
}
