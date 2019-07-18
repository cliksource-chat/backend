package com.collabera.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Messages {
	

	@Id
	private ObjectId id;
	private Users sender;
	private String message;
	private ChatRooms chatRooms;
	private Date timestamp;
	
	public Messages() {}

	public Messages(ObjectId id, Users sender, String message, ChatRooms chatRooms, Date timestamp) {
		super();
		this.id = id;
		this.sender = sender;
		this.message = message;
		this.chatRooms = chatRooms;
		this.timestamp = timestamp;
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

	public ChatRooms getChatRooms() {
		return chatRooms;
	}

	public void setChatRooms(ChatRooms chatRooms) {
		this.chatRooms = chatRooms;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Date getTimeStamp() {
		return this.timestamp;
	}
	public void setTimeStamp(Date d) {
		this.timestamp = d;
	}

	@Override
	public String toString() {
		return "Messages [id=" + id.toHexString() + ", sender=" + sender + ", message=" + message + ", chatRooms=" + chatRooms + ", timeStamp=" + timestamp + "]";
	}


	
}
