package com.collabera.archive_models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Users_Archive {

	@Id
	public ObjectId id;
	
	public String firstname;
	public String lastname;
	public String type;
	public Boolean isActive;
	
	public Users_Archive() {
		
	}
	
	public Users_Archive(ObjectId id, String firstname, String lastname, String type, Boolean isActive) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
		this.isActive = isActive;
	}
	
	public String getid() {
		return id.toHexString();
	}
	
	public void setid(ObjectId id) {
		this.id = id;
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
	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}