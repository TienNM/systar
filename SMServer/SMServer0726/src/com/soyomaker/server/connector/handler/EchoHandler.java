package com.soyomaker.server.connector.handler;

import com.soyomaker.data.GObject;
import com.soyomaker.data.IGObject;
import com.soyomaker.server.connector.GUSession;

public class EchoHandler implements IRequestHandler {
	@Override
	public void handleMessage(GUSession session, IGObject obj) {
		GObject msg = new GObject();
		msg.putString("type", "echo");
		msg.putObject("content", obj);

		session.sendMessage(msg);
	}
}
