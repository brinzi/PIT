package com.servlets;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import com.chatstuff.ChatCreator;
import com.chatstuff.ChatEngine;

/**
 * Servlet implementation class SocketServlet
 */

public class SocketServlet extends WebSocketServlet {
	private static final long serialVersionUID = 1L;
	
	
	private ChatEngine chatEngine= new ChatEngine();
	
	

	@Override
	public void configure(WebSocketServletFactory factory) { 
		factory.setCreator(new ChatCreator(chatEngine));
		factory.getPolicy().setIdleTimeout(0);

	}

}

