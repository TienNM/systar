package com.soyomaker.business;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;

import com.soyomaker.lang.GameObject;
import com.soyomaker.net.mina.PackageConst;

/**
 * SocketTestClient
 * 
 * @author wp_g4
 * 
 */
public class SocketTest {

	public static void main(String[] args) {
		boolean running = true;
		GameObject msg = new GameObject();
		msg.setType("101001");
		msg.putString("username", "大哥大");
		msg.putString("password", "2724504");
		Collection<GameObject> c = new ArrayList<GameObject>();
		c.add(msg);
		GameObject packSend = new GameObject();
		packSend.setType(PackageConst.PACKAGE_TYPE_NAME);
		packSend.putObjectArray(PackageConst.PACKAGE_ARRAY_KEY, c);
		packSend.toBinary();
		try {
			Socket socket = new Socket("localhost", 9090);
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			byte[] dataSent = packSend.toBinary();
			dos.writeInt(dataSent.length);
			dos.write(dataSent);
			dos.flush();
			System.out.println("socket发出:" + packSend.toJson());
			while (running) {
				int len = dis.readInt();
				byte[] bytes = new byte[len];
				dis.read(bytes);
				GameObject resMsg = GameObject.createFromBytes(bytes);
				System.out.println("socket收到:" + resMsg.toJson());
			}
			dis.close();
			is.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
