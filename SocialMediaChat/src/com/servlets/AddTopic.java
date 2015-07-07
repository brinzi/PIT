package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbstuff.TopicSqlImplement;
import com.topicdata.Topic;

/**
 * Servlet implementation class AddTopic
 */

public class AddTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TopicSqlImplement dbActions;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTopic() {
		super();
		dbActions = new TopicSqlImplement();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		Topic topic = new Topic(request.getParameter("title"),
				request.getParameter("content"), -1);
		dbActions.addItem(topic);
		
		response.sendRedirect("main.jsp");

	}

}
