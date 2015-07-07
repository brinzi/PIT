package com.userdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class User {



	private String email, password, name;
	private int id;
	private Map<Integer , String > friendList;
	private List<Notification> myNotifications;
	
	
	public User(User e) {
		super();
		this.email = e.getEmail();
		this.password = e.getPassword();
		this.name = e.getName();
		this.id = e.getId();
	}

	

	/**
	 * @param id
	 * @param name
	 * @param email
	 */
	public User(int id, String name, String email) {
	
		this.email = email;
		this.name = name;
		this.id = id;
		this.friendList=new HashMap<Integer, String>();
		this.myNotifications=new ArrayList<Notification>();
	}
	
	

	/**
	 * @param email
	 * @param password
	 * @param name
	 */
	public User(String email, String password, String name) {
		
		this.email = email;
		this.password = password;
		this.name = name;
		this.friendList=new HashMap<Integer, String>();
		this.myNotifications=new ArrayList<Notification>();
	}



	public User(String email, String password) {
		this.email=email;
		this.password=password;
		this.friendList=new HashMap<Integer, String>();
		this.myNotifications=new ArrayList<Notification>();
	}
	
	
	public User(int id, String email, String password, String name) {
		this.id = id; 
		this.email = email;
		this.password = password;
		this.name=name;
	}
	
	

	/**
	 * @param email
	 * @param password
	 * @param name
	 * @param id
	 * @param friendList
	 * @param myNotifications
	 */
	public User(String email, String password, String name, int id,
			Map<Integer, String> friendList, List<Notification> myNotifications) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.id = id;
		this.friendList = friendList;
		this.myNotifications = myNotifications;
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
	
	
	public Map<Integer, String> getFriendList() {
		return friendList;
	}



	public void setFriendList(HashMap<Integer, String> friendList) {
		this.friendList = friendList;
	}

	
	
	public void addFriend(User x){
		
		friendList.put(x.getId(), x.getName());
		
	}
	 
	
	public void addNotification(Notification n){
		myNotifications.add(n);
		
	}
	
	public void removeNotification(int id){
		Iterator<Notification> iter = myNotifications.iterator();

		while (iter.hasNext()) {
		   
		    if (iter.next().getId()==id)
		        iter.remove();
		}
	}


	public List<Notification> getMyNotifications() {
		return myNotifications;
	}



	public void setMyNotifications(List<Notification> myNotifications) {
		this.myNotifications = myNotifications;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	
	

}
