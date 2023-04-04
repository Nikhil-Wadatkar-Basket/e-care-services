package com.bs.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MedicineCounter")
public class MedicineCounter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer receiptID;
	private String patrientName;
	private String contact;
	private String medName;
	private Integer quantity;
	private Integer price;

	public MedicineCounter() {
		// TODO Auto-generated constructor stub
	}

	public MedicineCounter(Integer receiptID, String patrientName, String contact, String medName, Integer quantity,
			Integer price) {
		super();
		this.receiptID = receiptID;
		this.patrientName = patrientName;
		this.contact = contact;
		this.medName = medName;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getReceiptID() {
		return receiptID;
	}

	public void setReceiptID(Integer receiptID) {
		this.receiptID = receiptID;
	}

	public String getPatrientName() {
		return patrientName;
	}

	public void setPatrientName(String patrientName) {
		this.patrientName = patrientName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MedicineCounter [receiptID=" + receiptID + ", patrientName=" + patrientName + ", contact=" + contact
				+ ", medName=" + medName + ", quantity=" + quantity + ", price=" + price + "]";
	}
}
