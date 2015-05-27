package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbstuff.UserSqlImplement;
import com.userdata.User;

/**
 * Servlet implementation class LogIn
 */
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	UserSqlImplement dbActions;

	public LogIn() {
		super();
		dbActions = new UserSqlImplement();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		User x =new User(request.getParameter("login"), request
				.getParameter("password"));
		System.out.println(x.getEmail()+x.getPassword());
		if (dbActions.findUser(x) ){
			System.out.println("asdasdasdas");
			response.sendRedirect("main.jsp");

		}

	}

}
