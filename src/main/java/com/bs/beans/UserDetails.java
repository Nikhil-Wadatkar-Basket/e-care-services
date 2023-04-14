package com.bs.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userID;
	private String userName;
	private String password;
	private String role;
	private String name;
	private String email;
	private String city;
	private String status;
	@Column(name = "access_code")
	private String accessCode;
	private String app_create_flag;
	private String app_delete_flag;
	private String app_update_flag;
	private String app_show_flag;

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}

	public UserDetails(Integer userID, String userName, String password, String role, String name, String email,
			String city, String status, String accessCode) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.name = name;
		this.email = email;
		this.city = city;
		this.status = status;
		this.accessCode = accessCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public String getApp_create_flag() {
		return app_create_flag;
	}

	public void setApp_create_flag(String app_create_flag) {
		this.app_create_flag = app_create_flag;
	}

	public String getApp_delete_flag() {
		return app_delete_flag;
	}

	public void setApp_delete_flag(String app_delete_flag) {
		this.app_delete_flag = app_delete_flag;
	}

	public String getApp_update_flag() {
		return app_update_flag;
	}

	public void setApp_update_flag(String app_update_flag) {
		this.app_update_flag = app_update_flag;
	}

	public String getApp_show_flag() {
		return app_show_flag;
	}

	public void setApp_show_flag(String app_show_flag) {
		this.app_show_flag = app_show_flag;
	}

	@Override
	public String toString() {
		return "UserDetails [userID=" + userID + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", name=" + name + ", email=" + email + ", city=" + city + ", status=" + status + ", accessCode="
				+ accessCode + ", app_create_flag=" + app_create_flag + ", app_delete_flag=" + app_delete_flag
				+ ", app_update_flag=" + app_update_flag + ", app_show_flag=" + app_show_flag + "]";
	}

}
