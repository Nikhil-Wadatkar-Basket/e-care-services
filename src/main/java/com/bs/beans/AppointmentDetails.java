package com.bs.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AppointmentDetails")
public class AppointmentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appID;
	private Integer userID;
	private Integer doctorID;
	private Date appDate;
	private String patientName;
	private String doctorName;

	public AppointmentDetails() {
		// TODO Auto-generated constructor stub
	}

	public AppointmentDetails(Integer appID, Integer userID, Integer doctorID, Date appDate, String patientName,
			String doctorName) {
		super();
		this.appID = appID;
		this.userID = userID;
		this.doctorID = doctorID;
		this.appDate = appDate;
		this.patientName = patientName;
		this.doctorName = doctorName;
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
				+ appDate + ", patientName=" + patientName + ", doctorName=" + doctorName + "]";
	}

}
