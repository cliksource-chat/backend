package com.collabera.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="Chat_Room")
public class ChatRooms_Archived {
	
	@Id
	@GeneratedValue
	private int Chat_Room_id;
	
	@Column(name="Date Created")
	private Date Date_created;
	
	@Column(name="Date Created")
	private  Users_Archived user1;
	
	@Column(name="User 2")
	private  Users_Archived user2;
	
	@Column(name="Mongo Id")
	private String MongoId;
	
	public ChatRooms_Archived() {
		
	}
	
	public ChatRooms_Archived(int Chat_Room_id, Date Date_created, Users_Archived user1, Users_Archived user2) {
		this.Chat_Room_id = Chat_Room_id;
		this.Date_created = Date_created;
		this.user1 = user1;
		this.user2 =  user2;
	}
	
	public int getid() {
		return Chat_Room_id;
	}

	public void setid(int chat_Room_id) {
		Chat_Room_id = chat_Room_id;
	}

		public String getMongoId() {
		return MongoId;
}

	public void setMongoId(String mongoId) {
		MongoId = mongoId;
	}

	public Date getCreated() {
		return Date_created;
	}

	public void setCreated(Date Date_created) {
		this.Date_created = Date_created;
	}

	public Users_Archived getUser1() {
		return user1;
	}

	public void setUser1(Users_Archived user1) {
		this.user1 = user1;
	}

	public Users_Archived getUser2() {
		return user2;
	}

	public void setUser2(Users_Archived user2) {
		this.user2 = user2;
	}
	
}

