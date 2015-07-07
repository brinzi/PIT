package com.servlets;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 * Servlet implementation class SocketServlet
 */

public class SocketServlet extends WebSocketServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void configure(WebSocketServletFactory factory) {
		
		factory.register(ChatWebSocket.class);
		factory.getPolicy().setIdleTimeout(0);

	}

}
