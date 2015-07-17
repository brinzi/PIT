package com.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dbstuff.TopicSqlImplement;
import com.topicdata.Topic;

/**
 * Servlet implementation class AddTopic
 */
@MultipartConfig
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
		/*
		 * response.setContentType("text/html");
		 * 
		 * Topic topic = new Topic(request.getParameter("title"),
		 * request.getParameter("content"), -1);
		 * System.out.println(request.getParameter("file"));
		 * dbActions.addItem(topic);
		 */
		Topic topic;
		response.setContentType("multipart/form-data");
		
		Part filePart = request.getPart("file");
		if (filePart.getSize() != 0) {
			InputStream fileContent = filePart.getInputStream();
			System.out.println(filePart.getSubmittedFileName());

			System.out.println(getServletContext().getRealPath("/"));
			FileOutputStream out = new FileOutputStream(getServletContext()
					.getRealPath("/")
					+ "/files"
					+ java.io.File.separator
					+ filePart.getSubmittedFileName());
			int read;
			byte[] bytes = new byte[1024];
			while ((read = fileContent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			fileContent.close();
			out.close();
		
		topic = new Topic(request.getParameter("title"),
				request.getParameter("content"), -1, "files/"
						+ filePart.getSubmittedFileName());
		}
		else 
		topic = new Topic(request.getParameter("title"),
				request.getParameter("content"), -1, "");
		dbActions.addItem(topic);

		response.sendRedirect("main.jsp");

	}

}
