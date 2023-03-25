package com.bs.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_details")
public class PatientDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patientID;
	private String patientName;
	private String doctorName;
	private Integer patientAge;
	private String city;
	private String bloodGroup;
	private Integer weight;
	private Integer height;
	private Integer bp;
	private Integer sugar;
	private String contact;
	private String patientType;
	private Date appDate;
	private String appTime;

	public PatientDetails() {

	}

	public PatientDetails(Integer patientID, String patientName, String doctorName, Integer patientAge, String city,
			String bloodGroup, Integer weight, Integer height, Integer bp, Integer sugar, String contact,
			String appTime, String patientType, Date appDate) {
		super();
		this.patientID = patientID;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.patientAge = patientAge;
		this.city = city;
		this.bloodGroup = bloodGroup;
		this.weight = weight;
		this.height = height;
		this.bp = bp;
		this.sugar = sugar;
		this.contact = contact;
		this.appTime = appTime;
		this.patientType = patientType;
		this.appDate = appDate;
	}

	public String getAppTime() {
		return appTime;
	}

	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}

	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientType() {
		return patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getPatientID() {
		return patientID;
	}

	public void setPatientID(Integer patientID) {
		this.patientID = patientID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Integer getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(Integer patientAge) {
		this.patientAge = patientAge;
	}

	@Override
	public String toString() {
		return "PatientDetails [patientID=" + patientID + ", patientName=" + patientName + ", doctorName=" + doctorName
				+ ", patientAge=" + patientAge + ", city=" + city + ", bloodGroup=" + bloodGroup + ", weight=" + weight
				+ ", height=" + height + ", bp=" + bp + ", sugar=" + sugar + ", contact=" + contact + ", appTime="
				+ appTime + ", patientType=" + patientType + ", appDate=" + appDate + "]";
	}

}
