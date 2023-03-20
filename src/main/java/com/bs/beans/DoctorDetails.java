package com.bs.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor_details")
public class DoctorDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer docID;
	private String docName;
	private String designation;
	private String docContact;
	private Integer appID;

	public DoctorDetails() {

	}

	public DoctorDetails(Integer docID, String docName, String designation, String docContact, Integer appID) {
		super();
		this.docID = docID;
		this.docName = docName;
		this.designation = designation;
		this.docContact = docContact;
		this.appID = appID;
	}

	public Integer getDocID() {
		return docID;
	}

	public void setDocID(Integer docID) {
		this.docID = docID;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDocContact() {
		return docContact;
	}

	public void setDocContact(String docContact) {
		this.docContact = docContact;
	}

	public Integer getAppID() {
		return appID;
	}

	public void setAppID(Integer appID) {
		this.appID = appID;
	}

	@Override
	public String toString() {
		return "DoctorDetails [docID=" + docID + ", docName=" + docName + ", designation=" + designation
				+ ", docContact=" + docContact + ", appID=" + appID + "]";
	}

}
