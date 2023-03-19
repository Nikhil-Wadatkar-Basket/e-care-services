package com.bs.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails {
	@Id
	private Integer userID;
	private String userName;
	private String userAge;
	private String userContact;

	public UserDetails() {

	}

	public UserDetails(Integer userID, String userName, String userAge, String userContact) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userAge = userAge;
		this.userContact = userContact;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	@Override
	public String toString() {
		return "UserDetails [userID=" + userID + ", userName=" + userName + ", userAge=" + userAge + ", userContact="
				+ userContact + "]";
	}

}
