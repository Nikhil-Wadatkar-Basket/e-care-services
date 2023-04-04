package com.bs.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserDetails {
	@Id
	private Integer userID;
	private String userName;
	private String password;
	private String role;

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}

	public UserDetails(Integer userID, String userName, String password, String role) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.role = role;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDetails [userID=" + userID + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ "]";
	}

}
