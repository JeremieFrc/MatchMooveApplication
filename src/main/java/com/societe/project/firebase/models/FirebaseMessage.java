package com.societe.project.firebase.models;

import com.societe.project.models.Message;

public class FirebaseMessage {

	private Integer id;
	private Message message;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
}
