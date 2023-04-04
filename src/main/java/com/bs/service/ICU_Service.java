package com.bs.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.ICUDetails;
import com.bs.repo.ICURepo;

@Service
public class ICU_Service {

	@Autowired
	private ICURepo icu_repo;

	public ICUDetails createICUDetails(ICUDetails icuDetails) {
		icuDetails.setDischargeStatus("N");
		icuDetails.setFees(0);
		return icu_repo.save(bookBed(icuDetails));
	}

	private ICUDetails bookBed(ICUDetails icuDetails) {
		ICUDetails icuDetailsByBedNumber = getICUDetailsByBedNumber(icuDetails.getBedNumber());
		icuDetailsByBedNumber.setAge(icuDetails.getAge());
		icuDetailsByBedNumber.setPatientName(icuDetails.getPatientName());
		icuDetailsByBedNumber.setDoctorName(icuDetails.getDoctorName());
		icuDetailsByBedNumber.setFees(icuDetails.getFees());
		icuDetailsByBedNumber.setAppDate(icuDetails.getAppDate());
		icuDetailsByBedNumber.setCity(icuDetails.getCity());
		icuDetailsByBedNumber.setBloodGroup(icuDetails.getBloodGroup());
		icuDetailsByBedNumber.setWeight(icuDetails.getWeight());
		icuDetailsByBedNumber.setHeight(icuDetails.getHeight());
		icuDetailsByBedNumber.setBp(icuDetails.getBp());
		icuDetailsByBedNumber.setSugar(icuDetails.getSugar());
		icuDetailsByBedNumber.setContact(icuDetails.getContact());
		icuDetailsByBedNumber.setDischargeStatus("N");
		icuDetailsByBedNumber.setIcuBedStatus("Book");
//		icuDetailsByBedNumber.setIcuBedStatus("Book");
		return icuDetailsByBedNumber;

	}

	public ICUDetails updateICUDetails(ICUDetails icuDetails) {
		System.out.println("ICU_Service.updateICUDetails()");
		System.out.println("already details:"+icuDetails);
		ICUDetails updated = null;
		ICUDetails existedAppointmentDetails = getICUDetailsByBedNumber(icuDetails.getBedNumber());
		updated = new ICUDetails();
		System.out.println("Updated Bed based :" + updated);
		
		
		
		updated.setPatientName(icuDetails.getPatientName());
		updated.setDoctorName(icuDetails.getDoctorName());
		updated.setIcuBedStatus("book");
		updated.setFees(icuDetails.getFees());
		updated.setAppDate(icuDetails.getAppDate());
		updated.setCity(icuDetails.getCity());
		updated.setBloodGroup(icuDetails.getBloodGroup());
		updated.setAge(icuDetails.getAge());
		updated.setWeight(icuDetails.getWeight());
		updated.setHeight(icuDetails.getHeight());
		updated.setBp(icuDetails.getBp());
		updated.setSugar(icuDetails.getSugar());
		updated.setContact(icuDetails.getContact());
		updated.setIcuID(existedAppointmentDetails.getIcuID());
		updated.setBedNumber(existedAppointmentDetails.getBedNumber());
		

//		existedAppointmentDetails.setPatientName(icuDetails.getPatientName());
//		existedAppointmentDetails.setDoctorName(icuDetails.getDoctorName());
//		existedAppointmentDetails.setIcuBedStatus("book");
//		existedAppointmentDetails.setFees(icuDetails.getFees());
//		existedAppointmentDetails.setAppDate(icuDetails.getAppDate());
//		existedAppointmentDetails.setCity(icuDetails.getCity());
//		existedAppointmentDetails.setBloodGroup(icuDetails.getBloodGroup());
//		existedAppointmentDetails.setAge(icuDetails.getAge());
//		existedAppointmentDetails.setWeight(icuDetails.getWeight());
//		existedAppointmentDetails.setHeight(icuDetails.getHeight());
//		existedAppointmentDetails.setBp(icuDetails.getBp());
//		existedAppointmentDetails.setSugar(icuDetails.getSugar());
//		existedAppointmentDetails.setContact(icuDetails.getContact());
//		existedAppointmentDetails.setIcuID(icuDetails.getIcuID());
//		existedAppointmentDetails.setBedNumber(icuDetails.getBedNumber());

		// delete
//		dele
		System.out.println("before updated saving:"+updated);
		return icu_repo.save(updated);
	}

	public ICUDetails getICUDetailsByID(Integer id) {
		Optional<ICUDetails> findById = icu_repo.findById(id);
		if (findById.isPresent())
			return findById.get();
		else
			return null;
	}

	public List<ICUDetails> getAllICUDetails() {

		List<ICUDetails> findAll = icu_repo.findAll();
		return findAll;
	}

	public String deleteICUDetailsByBedNumer(Integer edNumber) {
		ICUDetails findAppointmentDetailsByAppTime = getICUDetailsByBedNumber(edNumber);

//		Integer patientID = findAppointmentDetailsByAppTime.getUserID();
		// delete patient while deleting his appointment
//		patientService.deletePatientDetailsByID(patientID);

		ICUDetails icuDetails = new ICUDetails();
		icuDetails.setIcuID(findAppointmentDetailsByAppTime.getIcuID());
		icuDetails.setIcuBedStatus("Free");
		icuDetails.setDischargeStatus("");
		icuDetails.setBedNumber(edNumber);

		ICUDetails findById = icu_repo.save(icuDetails);
		String message = "Not found";
		if (findById.getIcuBedStatus().equalsIgnoreCase("free")) {
			message = "Deleted";
		} else
			message = "Not found";
		return message;
	}

	public List<Integer> getFreeBeds() {

		List<ICUDetails> allICUDetails = getAllICUDetails();
		return allICUDetails.stream().filter(ap -> ap.getIcuBedStatus().equalsIgnoreCase("free"))
				.map(ap -> ap.getBedNumber()).collect(Collectors.toList());
	}

	public ICUDetails getICUDetailsByBedNumber(Integer time) {
		return icu_repo.findICUDetailsByBedNumber(time);
	}

	public String dischargeByBedNumber(Integer bedNumber) {
		ICUDetails existedAppointmentDetails = getICUDetailsByBedNumber(bedNumber);
		existedAppointmentDetails.setDischargeStatus("Y");
		
		return "discharged";
	}
}
