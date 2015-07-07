package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;

/**
 * Servlet implementation class ChatSocket
 */

public class ChatWebSocket implements WebSocketListener {

	private Session conn;
	private static List<ChatWebSocket> currentUsers=new ArrayList<ChatWebSocket>();;

	public ChatWebSocket() {

		}

	@Override
	public void onWebSocketBinary(byte[] arg0, int arg1, int arg2) {
		/* Don;t need it */

	}

	@Override
	public void onWebSocketClose(int arg0, String arg1) {
		conn.close();
		currentUsers.remove(this);

	}

	@Override
	public void onWebSocketConnect(
			org.eclipse.jetty.websocket.api.Session session) {
		System.out.println("connection is open");
		conn=session;
		currentUsers.add(this);
	}

	@Override
	public void onWebSocketError(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onWebSocketText(String msg) {

		System.out.println(msg);

		
		try {
			for (ChatWebSocket x : currentUsers) {
				x.conn.getRemote().sendString(msg);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
