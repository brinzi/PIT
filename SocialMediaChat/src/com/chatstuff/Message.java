package com.chatstuff;

import java.util.List;

public class Message {
	private int type, from;
	private List<Integer> to;
	private String value;

	/**
	 * @param type
	 * @param from
	 * @param to
	 * @param value
	 */
	public Message(int type, int from, List<Integer> to, String value) {
		super();
		this.type = type;
		this.from = from;
		this.to = to;
		this.value = value;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public List<Integer> getTo() {
		return to;
	}

	public void setTo(List<Integer> to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "Message [type=" + type + ", to=" + to + ", value=" + value
				+ "]";
	}

}
