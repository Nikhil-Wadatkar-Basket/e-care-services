package com.bs.helper;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bs.beans.AppointmentDetails;
import com.bs.beans.PatientDetails;
import com.bs.service.AppointmentService;
import com.bs.service.DoctorService;
import com.bs.service.MedicineService;
import com.bs.service.PatientService;

@Component
public class HelperService {

	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private MedicineService medicineService;

	public AppointmentDetails addPatientDetailsFromAppointment(AppointmentDetails appointmentDetails) {
		PatientDetails patientDetails = new PatientDetails();
		patientDetails.setPatientName(appointmentDetails.getPatientName());
		patientDetails.setPatientAge(appointmentDetails.getAge());
		patientDetails.setContact(appointmentDetails.getContact());
		patientDetails.setCity(appointmentDetails.getCity());
		patientDetails.setWeight(appointmentDetails.getWeight());
		patientDetails.setHeight(appointmentDetails.getHeight());
		patientDetails.setBloodGroup(appointmentDetails.getBloodGroup());
		patientDetails.setBp(appointmentDetails.getBp());
		patientDetails.setSugar(appointmentDetails.getSugar());
		patientDetails.setPatientType(appointmentDetails.getPatientType());
		patientDetails.setAppDate(appointmentDetails.getAppDate());
		patientDetails.setAppTime(appointmentDetails.getAppTime());

		// save patient
		PatientDetails savedPatient = patientService.createPatientDetails(patientDetails);

		// get appoint based on timimgs
		AppointmentDetails appointmentDetails2 = appointmentService
				.getAppointmentDetailsByAppTime(appointmentDetails.getAppTime());
		appointmentDetails2.setUserID(savedPatient.getPatientID());
		appointmentDetails2.setAge(savedPatient.getPatientAge());
		appointmentDetails2.setContact(savedPatient.getContact());
		appointmentDetails2.setCity(savedPatient.getCity());
		appointmentDetails2.setWeight(savedPatient.getWeight());
		appointmentDetails2.setHeight(savedPatient.getHeight());
		appointmentDetails2.setBloodGroup(savedPatient.getBloodGroup());
		appointmentDetails2.setBp(savedPatient.getBp());
		appointmentDetails2.setSugar(savedPatient.getSugar());

		if (appointmentDetails.getMeetingType().equalsIgnoreCase("New"))
			appointmentDetails2.setFees(200);
		else
			appointmentDetails2.setFees(100);

		appointmentDetails2.setAppTimeStatue("Booked");
		appointmentDetails2.setDoctorID(getDoctorIDByName(appointmentDetails.getDoctorName()));
		appointmentDetails2.setAppDate(appointmentDetails.getAppDate());
//		appointmentDetails2.setAppTime(appointmentDetails.getAppTime());
		appointmentDetails2.setMeetingType(appointmentDetails.getMeetingType());
		appointmentDetails2.setPatientName(savedPatient.getPatientName());
		appointmentDetails2.setDoctorName(appointmentDetails.getDoctorName());
		appointmentDetails2.setPatientType(appointmentDetails.getPatientType());

		// save appointments
		AppointmentDetails savedAppointmentDetails = appointmentService.updateAppointmentDetails(appointmentDetails2);
		return savedAppointmentDetails;
	}

	private Integer getDoctorIDByName(String doctorName) {
		AtomicInteger doctorID = new AtomicInteger();
		doctorService.getAllDoctorDetails().forEach(doc -> {
			if (doc.getDocName().equalsIgnoreCase(doctorName)) {
				doctorID.set(doc.getDocID());
			}
		});
		return doctorID.get();
	}

	public String deletePatientsFromAppointment(Integer patientID) {
		String message = "";
		PatientDetails details=patientService.getPatientDetailsByID(patientID);
//		AppointmentDetails appointmentByPatientID = appointmentService.getAppointmentByPatientID(Integer.valueOf(details.getAppTime()));
		AppointmentDetails appointmentByPatientID = appointmentService.getAppointmentDetailsByAppTime(details.getAppTime());
		message = appointmentService.deleteAppointmentDetailsByAppTime(appointmentByPatientID.getAppTime());
		return message;
	}

	public void createAppointmentforPatient(PatientDetails patient) {
		AppointmentDetails newAppointmentDetails = appointmentService
				.fetchAppointmentDetailsByAppTime(patient.getAppTime());

		newAppointmentDetails.setAge(patient.getPatientAge());
		newAppointmentDetails.setBloodGroup(patient.getBloodGroup());
		newAppointmentDetails.setBp(patient.getBp());
		newAppointmentDetails.setCity(patient.getCity());
		newAppointmentDetails.setContact(patient.getContact());
		newAppointmentDetails.setAge(Integer.valueOf(patient.getPatientAge()));
		newAppointmentDetails.setHeight(patient.getHeight());
		newAppointmentDetails.setWeight(patient.getWeight());
		newAppointmentDetails.setSugar(patient.getSugar());
		newAppointmentDetails.setUserID(patient.getPatientID());
		newAppointmentDetails.setSugar(patient.getSugar());
		newAppointmentDetails.setPatientName(patient.getPatientName());
		newAppointmentDetails.setPatientType(patient.getPatientType());

		newAppointmentDetails.setDoctorName(patient.getDoctorName());
		newAppointmentDetails.setPatientType(patient.getPatientType());
		newAppointmentDetails.setAppTime(patient.getAppTime());
		newAppointmentDetails.setMeetingType("New");
		newAppointmentDetails.setFees(200);
		newAppointmentDetails.setAppDate(patient.getAppDate());
		newAppointmentDetails.setAppTimeStatue("Booked");

		appointmentService.createAppointmentDetails(newAppointmentDetails);

	}

}
