package com.bs.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicine_details")
public class MedicineDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer medicineID;
	private String medicineName;
	private Date expDate;
	private Integer stock;
	private Integer price;

	public MedicineDetails() {

	}

	public MedicineDetails(Integer medicineID, String medicineName, Date expDate, Integer stock, Integer price) {
		super();
		this.medicineID = medicineID;
		this.medicineName = medicineName;
		this.expDate = expDate;
		this.stock = stock;
		this.price = price;
	}

	public Integer getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(Integer medicineID) {
		this.medicineID = medicineID;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MedicineDetails [medicineID=" + medicineID + ", medicineName=" + medicineName + ", expDate=" + expDate
				+ ", stock=" + stock + ", price=" + price + "]";
	}

}
