package com.chatstuff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.servlets.ChatWebSocket;


public class ChatEngine {

	private Map<Integer,ChatWebSocket> participants= new HashMap<>();;

	

	
	 public void remove(ChatWebSocket x) {
		 for (Integer i : participants.keySet()) {
			 if(participants.get(i).equals(x)){
				 participants.remove(i);
				 break;
			 }
			
		}	
	}

	public void add( Integer id, ChatWebSocket chatWebSocket) {
		participants.put(id,chatWebSocket);		
	}

	public Map<Integer, ChatWebSocket> getParticipants() {
		return participants;
	}

	public void setParticipants(Map<Integer, ChatWebSocket> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "ChatEngine [participants=" + participants + "]";
	}


	

}
