package com.collabera.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Users {

	@Id
	public ObjectId id;
	
	public String firstname;
	public String lastname;
	public String type;
		
	public Users() {
		
	}
	
	public Users(ObjectId id, String firstname, String lastname, String type) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
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


}
