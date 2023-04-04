package com.bs.mapper;

import java.util.Arrays;
import java.util.List;

public class MedcineInfo {
	public Integer medicineID;
	public String medicineName;
	public Integer quantity;
	public String expDate;

	public MedcineInfo() {
	}

	public MedcineInfo(Integer medicineID, String medicineName, Integer quantity, String expDate) {
		super();
		this.medicineID = medicineID;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.expDate = expDate;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "MedcineInfo [medicineID=" + medicineID + ", medicineName=" + medicineName + ", quantity=" + quantity
				+ ", expDate=" + expDate + "]";
	}
	
	public static List<MedcineInfo> getInfo(){
		return Arrays.asList(
					new MedcineInfo(10, "name1",12,"date 1"),
					new MedcineInfo(11, "name11",14,"date 1"),
					new MedcineInfo(12, "name12",15,"date 1"),
					new MedcineInfo(13, "name13",16,"date 1")
				);
	}

}