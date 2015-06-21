package com.userdata;

import java.io.Serializable;

public class Notification implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 369765610027968117L;
	/**
	 * 
	 */

	private int id,from;
	private String type;
	private boolean accepted;
	

	/**
	 * @param from
	 * @param type
	 * @param accepted
	 */
	public Notification(int from, String type, boolean accepted) {
		super();
		this.from = from;
		this.type = type;
		this.accepted = accepted;
	}


	/**
	 * @param id
	 * @param from
	 * @param type
	 * @param accepted
	 */
	public Notification(int id, int from, String type, boolean accepted) {
		super();
		this.id = id;
		this.from = from;
		this.type = type;
		this.accepted = accepted;
	}



	


	/**
	 * @param from
	 * @param type
	 */
	public Notification(int from, String type) {
		super();
		this.from = from;
		this.type = type;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}


	public int getFrom() {
		return from;
	}


	public void setFrom(int from) {
		this.from = from;
	}


	@Override
	public String toString() {
		return "Notification [id=" + id + ", from=" + from + ", type=" + type
				+ ", accepted=" + accepted + "]";
	}
	
	

}
