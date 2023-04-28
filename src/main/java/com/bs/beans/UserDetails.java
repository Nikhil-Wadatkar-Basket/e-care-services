package com.bs.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details_tab")
public class UserDetails {
	@Id
//	@GeneratedValue(strategy = GenerationType.)
	private String userID;
	private String userName;
	private String password;
	private String role;
	private String name;
	private String email;
	private String city;
	private String status;
	@Column(name = "access_code")
	private String accessCode;
	
	//dashboard flags
	
	private String app_dashborad_flag;
	private String pharm_dashborad_flag;
	private String doc_dashborad_flag;
	private String pat_dashborad_flag;
	private String vdoc_dashborad_flag;
	private String med_dashborad_flag;
	
	
	// appointments flags
	private String app_create_flag;
	private String app_delete_flag;
	private String app_update_flag;
	private String app_show_flag;
	
	//patient flags
	private String pat_create_flag;
	private String pat_delete_flag;
	private String pat_update_flag;
	private String pat_show_flag;
	//doctor flag
	private String doc_create_flag;
	private String doc_delete_flag;
	private String doc_update_flag;
	private String doc_show_flag;
	//visiting doctor
	private String vDoc_create_flag;
	private String vDoc_delete_flag;
	private String vDoc_update_flag;
	private String vDoc_show_flag;
	//medicine flags
	private String med_create_flag;
	private String med_delete_flag;
	private String med_update_flag;
	private String med_show_flag;
	//icu flags
	private String icu_create_flag;
	private String icu_delete_flag;
	private String icu_update_flag;
	private String icu_show_flag;
	//pharm flags
	private String pharm_create_flag;
	private String pharm_delete_flag;
	private String pharm_update_flag;
	private String pharm_show_flag;

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}

	public UserDetails(String userID, String userName, String password, String role, String name, String email,
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
	

	public String getApp_dashborad_flag() {
		return app_dashborad_flag;
	}

	public void setApp_dashborad_flag(String app_dashborad_flag) {
		this.app_dashborad_flag = app_dashborad_flag;
	}

	public String getPharm_dashborad_flag() {
		return pharm_dashborad_flag;
	}

	public void setPharm_dashborad_flag(String pharm_dashborad_flag) {
		this.pharm_dashborad_flag = pharm_dashborad_flag;
	}

	public String getDoc_dashborad_flag() {
		return doc_dashborad_flag;
	}

	public void setDoc_dashborad_flag(String doc_dashborad_flag) {
		this.doc_dashborad_flag = doc_dashborad_flag;
	}

	public String getPat_dashborad_flag() {
		return pat_dashborad_flag;
	}

	public void setPat_dashborad_flag(String pat_dashborad_flag) {
		this.pat_dashborad_flag = pat_dashborad_flag;
	}

	public String getVdoc_dashborad_flag() {
		return vdoc_dashborad_flag;
	}

	public void setVdoc_dashborad_flag(String vdoc_dashborad_flag) {
		this.vdoc_dashborad_flag = vdoc_dashborad_flag;
	}

	public String getMed_dashborad_flag() {
		return med_dashborad_flag;
	}

	public void setMed_dashborad_flag(String med_dashborad_flag) {
		this.med_dashborad_flag = med_dashborad_flag;
	}

	public String getPharm_create_flag() {
		return pharm_create_flag;
	}

	public void setPharm_create_flag(String pharm_create_flag) {
		this.pharm_create_flag = pharm_create_flag;
	}

	public String getPharm_delete_flag() {
		return pharm_delete_flag;
	}

	public void setPharm_delete_flag(String pharm_delete_flag) {
		this.pharm_delete_flag = pharm_delete_flag;
	}

	public String getPharm_update_flag() {
		return pharm_update_flag;
	}

	public void setPharm_update_flag(String pharm_update_flag) {
		this.pharm_update_flag = pharm_update_flag;
	}

	public String getPharm_show_flag() {
		return pharm_show_flag;
	}

	public void setPharm_show_flag(String pharm_show_flag) {
		this.pharm_show_flag = pharm_show_flag;
	}

	public String getPat_create_flag() {
		return pat_create_flag;
	}

	public void setPat_create_flag(String pat_create_flag) {
		this.pat_create_flag = pat_create_flag;
	}

	public String getPat_delete_flag() {
		return pat_delete_flag;
	}

	public void setPat_delete_flag(String pat_delete_flag) {
		this.pat_delete_flag = pat_delete_flag;
	}

	public String getPat_update_flag() {
		return pat_update_flag;
	}

	public void setPat_update_flag(String pat_update_flag) {
		this.pat_update_flag = pat_update_flag;
	}

	public String getPat_show_flag() {
		return pat_show_flag;
	}

	public void setPat_show_flag(String pat_show_flag) {
		this.pat_show_flag = pat_show_flag;
	}

	public String getDoc_create_flag() {
		return doc_create_flag;
	}

	public void setDoc_create_flag(String doc_create_flag) {
		this.doc_create_flag = doc_create_flag;
	}

	public String getDoc_delete_flag() {
		return doc_delete_flag;
	}

	public void setDoc_delete_flag(String doc_delete_flag) {
		this.doc_delete_flag = doc_delete_flag;
	}

	public String getDoc_update_flag() {
		return doc_update_flag;
	}

	public void setDoc_update_flag(String doc_update_flag) {
		this.doc_update_flag = doc_update_flag;
	}

	public String getDoc_show_flag() {
		return doc_show_flag;
	}

	public void setDoc_show_flag(String doc_show_flag) {
		this.doc_show_flag = doc_show_flag;
	}

	public String getvDoc_create_flag() {
		return vDoc_create_flag;
	}

	public void setvDoc_create_flag(String vDoc_create_flag) {
		this.vDoc_create_flag = vDoc_create_flag;
	}

	public String getvDoc_delete_flag() {
		return vDoc_delete_flag;
	}

	public void setvDoc_delete_flag(String vDoc_delete_flag) {
		this.vDoc_delete_flag = vDoc_delete_flag;
	}

	public String getvDoc_update_flag() {
		return vDoc_update_flag;
	}

	public void setvDoc_update_flag(String vDoc_update_flag) {
		this.vDoc_update_flag = vDoc_update_flag;
	}

	public String getvDoc_show_flag() {
		return vDoc_show_flag;
	}

	public void setvDoc_show_flag(String vDoc_show_flag) {
		this.vDoc_show_flag = vDoc_show_flag;
	}

	public String getMed_create_flag() {
		return med_create_flag;
	}

	public void setMed_create_flag(String med_create_flag) {
		this.med_create_flag = med_create_flag;
	}

	public String getMed_delete_flag() {
		return med_delete_flag;
	}

	public void setMed_delete_flag(String med_delete_flag) {
		this.med_delete_flag = med_delete_flag;
	}

	public String getMed_update_flag() {
		return med_update_flag;
	}

	public void setMed_update_flag(String med_update_flag) {
		this.med_update_flag = med_update_flag;
	}

	public String getMed_show_flag() {
		return med_show_flag;
	}

	public void setMed_show_flag(String med_show_flag) {
		this.med_show_flag = med_show_flag;
	}

	public String getIcu_create_flag() {
		return icu_create_flag;
	}

	public void setIcu_create_flag(String icu_create_flag) {
		this.icu_create_flag = icu_create_flag;
	}

	public String getIcu_delete_flag() {
		return icu_delete_flag;
	}

	public void setIcu_delete_flag(String icu_delete_flag) {
		this.icu_delete_flag = icu_delete_flag;
	}

	public String getIcu_update_flag() {
		return icu_update_flag;
	}

	public void setIcu_update_flag(String icu_update_flag) {
		this.icu_update_flag = icu_update_flag;
	}

	public String getIcu_show_flag() {
		return icu_show_flag;
	}

	public void setIcu_show_flag(String icu_show_flag) {
		this.icu_show_flag = icu_show_flag;
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

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
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
