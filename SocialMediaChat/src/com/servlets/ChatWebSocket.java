package com.servlets;

import java.io.IOException;
import java.util.Map;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;

import com.chatstuff.ChatEngine;
import com.chatstuff.Message;
import com.google.gson.Gson;

/**
 * Servlet implementation class ChatSocket
 */

public class ChatWebSocket implements WebSocketListener {

	private Session conn;
	private ChatEngine chatRooms;

	public ChatWebSocket(ChatEngine e) {
		chatRooms = e;
	}

	@Override
	public void onWebSocketBinary(byte[] arg0, int arg1, int arg2) {
		/* Don;t need it */

	}

	@Override
	public void onWebSocketClose(int id, String arg1) {
		conn.close();
		chatRooms.remove(this);

	}

	@Override
	public void onWebSocketConnect(Session session) {
		System.out.println("connection is open");
		conn = session;

	}

	@Override
	public void onWebSocketError(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onWebSocketText(String text) {
		System.out.println(text);
		Message msg = new Gson().fromJson(text, Message.class);
		System.out.println(msg.getValue().toString());
		if (msg.getType() == 0) {

			chatRooms.add(Integer.parseInt(msg.getValue()), this);
			System.out.println("Connection Opened " + chatRooms.toString());
		} else {
			try {

				Map<Integer, ChatWebSocket> map = chatRooms.getParticipants();
				for (Integer x : msg.getTo()) {
					System.out.println(x);
					if (map.containsKey(x)) {

						map.get(x).conn.getRemote().sendString(text);
					}
				}
				if (map.containsKey(msg.getFrom()));
					this.conn.getRemote().sendString(text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
