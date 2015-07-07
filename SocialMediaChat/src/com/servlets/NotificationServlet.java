
package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbstuff.NotificationsSql;
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
		String username=request.getParameter("input");
		
		UserSqlImplement userDbActions= new UserSqlImplement();
		User user=userDbActions.findUser(username);
		
		user.setMyNotifications((List<Notification>) userDbActions.getNotifications(user.getId()));
		
		Notification n= new Notification(user.getId(), "Friend request");
		user.addNotification(n);
		userDbActions.loadNotifications(user.getMyNotifications(), user.getId());
		
		NotificationsSql notificationsDbAction= new NotificationsSql();
		notificationsDbAction.addItem(n);
		
		
		
		
	}

}
