package com.bs.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visiting_doctor_details")
public class VisitingDoctorDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer docID;
	private String docName;
	private String designation;
	private String docContact;
	private Date visitingDate;

	public VisitingDoctorDetails() {

	}

	public VisitingDoctorDetails(Integer docID, String docName, String designation, String docContact,
			Date visitingDate) {
		super();
		this.docID = docID;
		this.docName = docName;
		this.designation = designation;
		this.docContact = docContact;
		this.visitingDate = visitingDate;
	}

	public Date getVisitingDate() {
		return visitingDate;
	}

	public void setVisitingDate(Date visitingDate) {
		this.visitingDate = visitingDate;
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

	@Override
	public String toString() {
		return "VisitingDoctorDetails [docID=" + docID + ", docName=" + docName + ", designation=" + designation
				+ ", docContact=" + docContact + ", visitingDate=" + visitingDate + "]";
	}

}
