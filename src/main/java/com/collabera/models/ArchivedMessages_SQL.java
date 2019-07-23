package com.collabera.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
@Entity
@Table(name="Messages")
public class ArchivedMessages_SQL {
	
	@Id
	@GeneratedValue
	private int ArchivedMessages_Id;
	
	@Column(name="Mongo Id")
	private String mongo_Id;
	
	@Column(name="Message")
	private String message;
	
	@Column(name="Sender")
	private Users_Archived sender;
	
	@Column(name="Chat Rooms")
	private ChatRooms_Archived chatRooms_Archived;
	
	@Column(name="TimeStamp")
	private Date timestamp;

public ArchivedMessages_SQL() {}

public ArchivedMessages_SQL(int ArchivedMessages_Id, String mongo_Id, String message, Users_Archived sender, ChatRooms_Archived chatRooms_Archived, Date timestamp) {
	super();
	this.ArchivedMessages_Id = ArchivedMessages_Id;
	this.sender = sender;
	this.message = message;
	this.chatRooms_Archived = chatRooms_Archived;
	this.timestamp = timestamp;
}

public String getMongo_Id() {
	return mongo_Id;
}

public void setMongo_Id(String mongo_Id) {
	this.mongo_Id = mongo_Id;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public Users_Archived getSender() {
	return sender;
}

public void setSender(Users_Archived sender) {
	this.sender = sender;
}

public ChatRooms_Archived getChatRooms_Archived() {
	return chatRooms_Archived;
}

public void setChatRooms_Archived(ChatRooms_Archived chatRooms_Archived) {
	this.chatRooms_Archived = chatRooms_Archived;
}

public Date getTimestamp() {
	return timestamp;
}

public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
}


	
}
