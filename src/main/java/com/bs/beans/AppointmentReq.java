package com.bs.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AppointmentDetails")
public class AppointmentReq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appID;
	private Integer userID;
	private Integer doctorID;

	private Date appDate;
	private String patientName;
	private String doctorName;
	private String appTime;
	private String appTimeStatue;
	private String city;
	private String bloodGroup;
	private String meetingType;
	private Integer age;
	private Integer fees;
	private Integer weight;
	private Integer height;
	private Integer bp;
	private Integer sugar;
	private Integer contact;
	private String patientType;
	

	public AppointmentReq() {
		// TODO Auto-generated constructor stub
	}

	

	public AppointmentReq(Integer appID, Integer userID, Integer doctorID, Date appDate, String patientName,
			String doctorName, String appTime, String appTimeStatue, String city, String bloodGroup, String meetingType,
			Integer age, Integer fees, Integer weight, Integer height, Integer bp, Integer sugar, Integer contact,String patientType) {
		super();
		this.appID = appID;
		this.userID = userID;
		this.doctorID = doctorID;
		this.appDate = appDate;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.appTime = appTime;
		this.appTimeStatue = appTimeStatue;
		this.city = city;
		this.bloodGroup = bloodGroup;
		this.meetingType = meetingType;
		this.age = age;
		this.fees = fees;
		this.weight = weight;
		this.height = height;
		this.bp = bp;
		this.sugar = sugar;
		this.contact = contact;
		this.patientType=patientType;
	}

	public String getPatientType() {
		return patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}




	public Integer getWeight() {
		return weight;
	}



	public void setWeight(Integer weight) {
		this.weight = weight;
	}



	public Integer getHeight() {
		return height;
	}



	public void setHeight(Integer height) {
		this.height = height;
	}



	public Integer getBp() {
		return bp;
	}



	public void setBp(Integer bp) {
		this.bp = bp;
	}



	public Integer getSugar() {
		return sugar;
	}



	public void setSugar(Integer sugar) {
		this.sugar = sugar;
	}



	public Integer getContact() {
		return contact;
	}



	public void setContact(Integer contact) {
		this.contact = contact;
	}



	public Integer getFees() {
		return fees;
	}

	public void setFees(Integer fees) {
		this.fees = fees;
	}

	public String getAppTime() {
		return appTime;
	}

	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}

	public String getAppTimeStatue() {
		return appTimeStatue;
	}

	public void setAppTimeStatue(String appTimeStatue) {
		this.appTimeStatue = appTimeStatue;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAppID() {
		return appID;
	}

	public void setAppID(Integer appID) {
		this.appID = appID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(Integer doctorID) {
		this.doctorID = doctorID;
	}

	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@Override
	public String toString() {
		return "AppointmentDetails [appID=" + appID + ", userID=" + userID + ", doctorID=" + doctorID + ", appDate="
				+ appDate + ", patientName=" + patientName + ", doctorName=" + doctorName + ", appTime=" + appTime
				+ ", appTimeStatue=" + appTimeStatue + ", city=" + city + ", bloodGroup=" + bloodGroup
				+ ", meetingType=" + meetingType + ", age=" + age + ", fees=" + fees + "]";
	}

}
