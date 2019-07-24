package com.collabera.archive_models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="archived_messages")
public class Messages_Archive {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="mongoId")
	private String mongoId;
	
	@Column(name="message")
	private String message;
	
	@ManyToOne
	@JoinColumn(name="sender")
	private Users_Archive sender;
	
	@ManyToOne
	@JoinColumn(name="chatroomId")
	private ChatRooms_Archive chatroom;
	
	@Column(name="timestamp")
	private Date timestamp;
	
	public Messages_Archive() {
		
	}
	
	public Messages_Archive(String mongoId, String message, Users_Archive sender, ChatRooms_Archive chatroom) {
		this.mongoId = mongoId;
		this.message = message;
		this.sender = sender;
		this.chatroom = chatroom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMongoId() {
		return mongoId;
	}

	public void setMongoId(String mongoId) {
		this.mongoId = mongoId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Users_Archive getSender() {
		return sender;
	}

	public void setSender(Users_Archive sender) {
		this.sender = sender;
	}

	public ChatRooms_Archive getChatroom() {
		return chatroom;
	}

	public void setChatroom(ChatRooms_Archive chatroom) {
		this.chatroom = chatroom;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	
	

}
