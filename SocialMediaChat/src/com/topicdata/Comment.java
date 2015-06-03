package com.topicdata;

public class Comment {

	private int id;

	private String content;

	private int userId;

	public Comment(String content, int userId) {
		this.content = content;
		this.userId = userId;
	}

	public Comment(int id, String content, int userId) {
		this.id = id;
		this.content = content;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	

}
