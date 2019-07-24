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
@Table(name="archived_chatrooms")
public class ChatRooms_Archive {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="mongoId")
	private String mongoId;
	
	@Column(name="created")
	private Date created;
	
	@ManyToOne
	@JoinColumn(name="user1")
	private Users_Archive user1;
	
	@ManyToOne
	@JoinColumn(name="user2")
	private Users_Archive user2;
	
	public ChatRooms_Archive() {
		
	}
	
	public ChatRooms_Archive(String mongoId, Users_Archive user1, Users_Archive user2, Date created) {
		this.mongoId = mongoId;
		this.user1 = user1;
		this.user2 = user2;
		this.created = created;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Users_Archive getUser1() {
		return user1;
	}

	public void setUser1(Users_Archive user1) {
		this.user1 = user1;
	}

	public Users_Archive getUser2() {
		return user2;
	}

	public void setUser2(Users_Archive user2) {
		this.user2 = user2;
	}
	
	
	
	

}
