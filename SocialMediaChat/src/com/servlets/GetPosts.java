package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;

import com.dbstuff.TopicSqlImplement;
import com.google.gson.Gson;
import com.topicdata.Topic;

/**
 * Servlet implementation class GetPosts
 */
public class GetPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	TopicSqlImplement dbActions;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPosts() {
        super();
        dbActions = new TopicSqlImplement();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");

		ArrayList<Topic> topics= dbActions.getAll();
//		for ( Topic i : topics)
//			System.out.println(i.getTitle());
		String gson = new Gson().toJson(topics);
	
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		//String json = JSONValue.toJSONString(topics);
		
		System.out.println(gson);
		
		response.getWriter().println(gson);
		
	}

}
