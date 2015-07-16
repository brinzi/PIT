package com.topicdata;

import java.util.ArrayList;

public class Topic {

	private int id;

	private String title;

	private String content;

	private int userId;
	
	private String fileName;

	
	private ArrayList<Comment> comments;
	
	public Topic() {}

	public Topic(String title, String content, int userId) {
		this.title = title;
		this.content = content;
		this.userId = userId;
	}

	public Topic(String title, String content, int userId, String fileName) {
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.fileName = fileName;
	}
	
	public Topic(int id, String title, String content, int userId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
	}
	
	public Topic(int id, String title, String content, int userId, String fileName) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.fileName = fileName;
	}
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

}
