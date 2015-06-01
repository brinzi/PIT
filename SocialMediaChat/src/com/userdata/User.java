package com.userdata;

public class User {

	private String email, password, name ;
	private int id;

	
	
	public User(User e) {
		super();
		this.email = e.getEmail();
		this.password = e.getPassword();
		this.name = e.getName();
		this.id = e.getId();
	}

	public User(String email, String password, String name ) {
		this.id =-1; 
		this.email = email;
		this.password = password;
		this.name=name;
	}
	
	public User(int id, String email, String password, String name) {
		this.id = id; 
		this.email = email;
		this.password = password;
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
