package com.collabera.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class ChatRooms {

	
	@Id
	private ObjectId id;
	private Date created;
	private Users user1;
	private Users user2;
	
	public ChatRooms() {
		
	}
	
	public ChatRooms(ObjectId id, Date created, Users user1, Users user2) {
		this.id = id;
		this.created = created;
		this.user1 = user1;
		this.user2 =  user2;
	}

	public String getId() {
		return id.toHexString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Users getUser1() {
		return user1;
	}

	public void setUser1(Users user1) {
		this.user1 = user1;
	}

	public Users getUser2() {
		return user2;
	}

	public void setUser2(Users user2) {
		this.user2 = user2;
	}
	
}
