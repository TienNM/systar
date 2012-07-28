package com.soyomaker.net;

import java.util.HashMap;
import java.util.Map;

import com.soyomaker.data.ISMObject;
import com.soyomaker.net.session.UserSession;

/**
 * 网络收发器。 负责发送和接收消息.
 * 
 * @author wp_g4
 * 
 */
public class NetTransceiver {

	private static NetTransceiver instance = new NetTransceiver();

	private Map<String, INetService> netServiceMap = new HashMap<String, INetService>();

	private Map<String, Protocol> protocolMap = new HashMap<String, Protocol>();

	public static NetTransceiver getInstance() {
		return instance;
	}

	private NetTransceiver() {

	}

	public void config(String configFile) {
		
	}

	/**
	 * 业务逻辑层发送消息
	 * 
	 * @param msg
	 */
	public void sendMessage(UserSession session, ISMObject msg) {

	}

	/**
	 * 分发消息到业务逻辑层
	 * 
	 * @param msg
	 */
	public void dispatchMessage(UserSession session, ISMObject msg) {

	}

}
