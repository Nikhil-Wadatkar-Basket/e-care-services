package com.bs.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

@Entity
@Table(name = "MedicinePatient")
public class MedicinePatient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mediPatID;
	private String patrientName;
	private String contact;
	private String city;
	private String receiptDate;
	private Integer totalPrice;

	public MedicinePatient() {
		// TODO Auto-generated constructor stub
	}

	public MedicinePatient(Integer mediPatID, String patrientName, String contact, String city, String date,
			Integer totalPrice) {
		super();
		this.mediPatID = mediPatID;
		this.patrientName = patrientName;
		this.contact = contact;
		this.city = city;
		this.receiptDate = date;
		this.totalPrice = totalPrice;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getPatrientName() {
		return patrientName;
	}

	public void setPatrientName(String patrientName) {
		this.patrientName = patrientName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getMediPatID() {
		return mediPatID;
	}

	public void setMediPatID(Integer mediPatID) {
		this.mediPatID = mediPatID;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "MedicinePatient [mediPatID=" + mediPatID + ", patrientName=" + patrientName + ", contact=" + contact
				+ ", city=" + city + ", receiptDate=" + receiptDate + ", totalPrice=" + totalPrice + "]";
	}

}
