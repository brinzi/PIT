package com.userdata;

import java.io.Serializable;

public class Notification implements Serializable {
	


	private static final long serialVersionUID = 1841415603446178402L;
	
	private int id;
	private String type, from, to;
	private boolean accepted;

	/**
	 * @param id
	 * @param type
	 * @param from
	 * @param to
	 * @param accepted
	 */
	public Notification(int id, String type, String from, String to,
			boolean accepted) {
		super();
		this.id = id;
		this.type = type;
		this.from = from;
		this.to = to;
		this.accepted = accepted;
	}

	/**
	 * @param type
	 * @param from
	 * @param to
	 */
	public Notification(String type, String from, String to) {

		this.type = type;
		this.from = from;
		this.to = to;
		this.accepted = false;
	}

	/**
	 * @param id
	 * @param type
	 * @param from
	 * @param to
	 * @param accepted
	 */
	public Notification(int id, String to, String type) {

		this.id = 0;
		this.type = type;
		this.from = "";
		this.to = to;
		this.accepted = false;
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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", from=" + from + ", type=" + type
				+ ", accepted=" + accepted + "]";
	}

}
