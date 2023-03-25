package com.bs.beans;

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
	private String stock;

	public MedicineDetails() {

	}

	public MedicineDetails(Integer medicineID, String medicineName, String stock) {
		super();
		this.medicineID = medicineID;
		this.medicineName = medicineName;
		this.stock = stock;
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

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "MedicineDetails [medicineID=" + medicineID + ", medicineName=" + medicineName + ", stock=" + stock
				+ "]";
	}

}
