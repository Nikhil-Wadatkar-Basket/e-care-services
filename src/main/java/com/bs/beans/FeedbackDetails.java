package com.bs.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class FeedbackDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedID;
	private String patientName;
	private String patientContact;
	private String description;
	private String city;
	private Date visitingDate;

	public FeedbackDetails() {
		// TODO Auto-generated constructor stub
	}

	public FeedbackDetails(Integer feedID, String patientName, String patientContact, String description, String city,
			Date visitingDate) {
		super();
		this.feedID = feedID;
		this.patientName = patientName;
		this.patientContact = patientContact;
		this.description = description;
		this.city = city;
		this.visitingDate = visitingDate;
	}

	public Integer getFeedID() {
		return feedID;
	}

	public void setFeedID(Integer feedID) {
		this.feedID = feedID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientContact() {
		return patientContact;
	}

	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getVisitingDate() {
		return visitingDate;
	}

	public void setVisitingDate(Date visitingDate) {
		this.visitingDate = visitingDate;
	}

	@Override
	public String toString() {
		return "FeedbackDetails [feedID=" + feedID + ", patientName=" + patientName + ", patientContact="
				+ patientContact + ", description=" + description + ", city=" + city + ", visitingDate=" + visitingDate
				+ "]";
	}

}
