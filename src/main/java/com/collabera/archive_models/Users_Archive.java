package com.collabera.archive_models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="archived_users")
public class Users_Archive {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="mongoId")
	private String mongoId;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	
	@Column(name="type")
	private String type;
	
	@Column(name="isActive")
	private boolean isActive;
	
	public Users_Archive() {
		
	}
	
	public Users_Archive(String mongoId, String first, String last, String type, boolean isActive) {
		this.mongoId = mongoId;
		this.firstname = first;
		this.lastname = last;
		this.type = type;
		this.isActive = isActive;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	

}
