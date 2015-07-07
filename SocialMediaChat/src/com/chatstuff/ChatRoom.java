package com.chatstuff;

import java.util.HashMap;
import java.util.Map;

import com.userdata.User;

public class ChatRoom {

	Map<Integer, User> participants;
	Map<Integer, String> messeges;

	public ChatRoom() {

		this.participants = new HashMap<>();
		messeges = new HashMap<>();
	}

	public void addParticipant(User p) {
		this.participants.put(p.getId(), p);

	}

	public void addMessege(Integer uId, String m) {
		this.messeges.put(uId, m);
	}
	
	
	

}
