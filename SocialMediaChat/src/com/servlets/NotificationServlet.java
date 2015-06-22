
package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbstuff.UserSqlImplement;
import com.userdata.Notification;
import com.userdata.User;

/**
 * Servlet implementation class NotificationServlet
 */
public class NotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sendTo=request.getParameter("sendTo");
	
		String[] users=sendTo.split(",");	
		UserSqlImplement userDbActions= new UserSqlImplement();
		System.out.println(users[0]);
		User userA=userDbActions.findUser(users[0]);
		User userB=userDbActions.findUser(users[1]);
		
		
		userA.setMyNotifications((List<Notification>) userDbActions.getNotifications(userA.getId()));
		Notification n= new Notification("Friend request",userB.getName(),userA.getName());
		userA.addNotification(n);
		userDbActions.loadNotifications(userA.getMyNotifications(), userA.getId());
		
		
		userB.setMyNotifications((List<Notification>) userDbActions.getNotifications(userB.getId()));
		n=new Notification(0,userA.getName(), "Pending");
		userB.addNotification(n);
		userDbActions.loadNotifications(userB.getMyNotifications(),userB.getId());
		
		
		
	}

}
