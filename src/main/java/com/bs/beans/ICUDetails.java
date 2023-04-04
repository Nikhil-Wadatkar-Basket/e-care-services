package com.bs.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ICUDetails")
public class ICUDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer icuID;
	private String patientName;
	private String doctorName;
	private Integer fees;
	private Date appDate;
	private String city;
	private String bloodGroup;
	private Integer age;
	private Integer weight;
	private Integer height;
	private Integer bp;
	private Integer sugar;
	private String contact;

	private String dischargeStatus;
	private String icuBedStatus;
	private Integer bedNumber;

	public ICUDetails() {

	}

	public ICUDetails(Integer icuID, String patientName, String doctorName, String icuBedStatus, Integer fees,
			Date appDate, Integer bedNumber, String city, String bloodGroup, Integer age, Integer weight,
			Integer height, Integer bp, Integer sugar, String contact, String dischargeStatus) {
		super();
		this.icuID = icuID;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.icuBedStatus = icuBedStatus;
		this.fees = fees;
		this.appDate = appDate;
		this.bedNumber = bedNumber;
		this.city = city;
		this.bloodGroup = bloodGroup;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.bp = bp;
		this.sugar = sugar;
		this.contact = contact;
		this.dischargeStatus = dischargeStatus;
	}

	public Integer getIcuID() {
		return icuID;
	}

	public void setIcuID(Integer icuID) {
		this.icuID = icuID;
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

	public String getIcuBedStatus() {
		return icuBedStatus;
	}

	public void setIcuBedStatus(String icuBedStatus) {
		this.icuBedStatus = icuBedStatus;
	}

	public Integer getFees() {
		return fees;
	}

	public void setFees(Integer fees) {
		this.fees = fees;
	}

	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	public Integer getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(Integer bedNumber) {
		this.bedNumber = bedNumber;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public String getDischargeStatus() {
		return dischargeStatus;
	}

	public void setDischargeStatus(String dischargeStatus) {
		this.dischargeStatus = dischargeStatus;
	}

	@Override
	public String toString() {
		return "ICUDetails [icuID=" + icuID + ", age=" + age + ", bedNumber=" + bedNumber + "]";
	}

}
