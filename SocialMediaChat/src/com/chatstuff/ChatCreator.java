package com.chatstuff;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;


import com.servlets.ChatWebSocket;


public class ChatCreator implements WebSocketCreator
{
    private ChatEngine chatEngine;

    public ChatCreator(ChatEngine engine)
    {
        this.chatEngine = engine;
    }
	
	public Object createWebSocket(ServletUpgradeRequest arg0,
			ServletUpgradeResponse arg1) {
		// TODO Auto-generated method stub
        return new ChatWebSocket(chatEngine);
	}


	
}
