package com.collabera.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="Users")
public class Users_Archived {

	@Id
	@GeneratedValue
	private int User_Id;
	
	@Column(name="Mongo Id")
	private String Mongo_Id;
	
	@Column(name="First Name")
	public String firstname;
	
	@Column(name="Last Name")
	public String lastname;
	
	@Column(name="Type")
	public String type;
	
	@Column(name="Is Active")
	public Boolean isActive;
	
	public Users_Archived() {	
	}
	
	public Users_Archived(String firstname, String lastname, String type, Boolean isActive, int User_Id, String Mongo_Id) {
		this.Mongo_Id = Mongo_Id;
		this.User_Id = User_Id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
		this.isActive = isActive;
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

	public int getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}

	public String getMongo_Id() {
		return Mongo_Id;
	}

	public void setMongo_Id(String mongo_Id) {
		Mongo_Id = mongo_Id;
	}
}