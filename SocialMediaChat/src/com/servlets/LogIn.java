package com.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		User user = new User(request.getParameter("email"),
				request.getParameter("password"));
		System.out.println(user.getEmail() + user.getPassword());
		if ((user=dbActions.findUser(user.hashCode()))!=null) {
			System.out.println((HashMap<Integer, String>)dbActions.getFriendList(user.getId()));
			user.setFriendList( (HashMap<Integer, String>) dbActions.getFriendList(user.getId()));
			//user.addFriend(dbActions.findUser(205821076));
			//System.out.println(user.getFriendList());
			
			JSONObject myMap=new JSONObject(user.getFriendList());
		
			
			
			
			//dbActions.loadFriendList(user.getFriendList(),user.getId());
			System.out.println(myMap);
			request.getSession().setAttribute("currentUser", user);
			request.getSession().setAttribute("myFriends", myMap);
			
			response.sendRedirect("main.jsp");

			

		}




	}
}
