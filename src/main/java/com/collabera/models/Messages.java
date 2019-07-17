package com.collabera.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Messages {
	
	@Id
	private ObjectId id;
	private Users sender;
	private String message;
	
	public Messages() {}

	public Messages(ObjectId id, Users sender, String message) {
		super();
		this.id = id;
		this.sender = sender;
		this.message = message;
	}

	public String getId() {
		return id.toHexString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Users getSender() {
		return sender;
	}

	public void setSender(Users sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
