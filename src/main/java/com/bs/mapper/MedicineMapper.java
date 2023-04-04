package com.bs.mapper;

import java.sql.Date;
import java.util.List;

public class MedicineMapper {

//	private MyInfo medicines;
	private List<MedcineInfo> infos;
	private String patientName;
	private String doctorName;
	private Date invoiceDate;

	public MedicineMapper() {

	}

	public MedicineMapper(List<MedcineInfo> infos, String patientName, String doctorName, Date invoiceDate) {
		super();
		this.infos = infos;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.invoiceDate = invoiceDate;
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

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public List<MedcineInfo> getInfos() {
		return infos;
	}

	public void setInfos(List<MedcineInfo> infos) {
		this.infos = infos;
	}

	@Override
	public String toString() {
		return "MedicineMapper [infos=" + infos + ", patientName=" + patientName + ", doctorName=" + doctorName
				+ ", invoiceDate=" + invoiceDate + "]";
	}

}
