package com.bs.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.AppointmentDetails;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepo appRepo;

	@Autowired
	private PatientService patientService;

	public AppointmentDetails createAppointmentDetails(AppointmentDetails appointmentDetails) {
		return appRepo.save(appointmentDetails);
	}

	public AppointmentDetails updateAppointmentDetails(AppointmentDetails appointmentDetails) {
		AppointmentDetails updated = null;
		AppointmentDetails existedAppointmentDetails = appRepo
				.findAppointmentDetailsByAppTime(appointmentDetails.getAppTime());
		existedAppointmentDetails.setDoctorID(appointmentDetails.getDoctorID());
		existedAppointmentDetails.setPatientName(appointmentDetails.getPatientName());
		existedAppointmentDetails.setDoctorName(appointmentDetails.getDoctorName());
		existedAppointmentDetails.setAppTimeStatue("Booked");
		existedAppointmentDetails.setMeetingType(appointmentDetails.getMeetingType());
		existedAppointmentDetails.setAppTime(appointmentDetails.getAppTime());
		existedAppointmentDetails.setFees(appointmentDetails.getFees());
		existedAppointmentDetails.setAppDate(appointmentDetails.getAppDate());
		existedAppointmentDetails.setUserID(appointmentDetails.getUserID());
		existedAppointmentDetails.setCity(appointmentDetails.getCity());
		existedAppointmentDetails.setBloodGroup(appointmentDetails.getBloodGroup());
		existedAppointmentDetails.setAge(appointmentDetails.getAge());
		existedAppointmentDetails.setWeight(appointmentDetails.getWeight());
		existedAppointmentDetails.setHeight(appointmentDetails.getHeight());
		existedAppointmentDetails.setBp(appointmentDetails.getBp());
		existedAppointmentDetails.setSugar(appointmentDetails.getSugar());
		existedAppointmentDetails.setContact(appointmentDetails.getContact());

		if (appointmentDetails.getMeetingType().equalsIgnoreCase("New"))
			existedAppointmentDetails.setFees(200);
		else
			existedAppointmentDetails.setFees(100);
		// delete
		return appRepo.save(existedAppointmentDetails);
	}

	public AppointmentDetails getAppointmentDetailsByID(Integer id) {
		Optional<AppointmentDetails> findById = appRepo.findById(id);
		if (findById.isPresent())
			return findById.get();
		else
			return null;
	}

	public List<AppointmentDetails> getAllAppointmentDetails() {
		return appRepo.findAll().stream().sorted(Comparator.comparing(AppointmentDetails::getAppID))
				.collect(Collectors.toList());
	}

	public String deleteAppointmentDetailsByAppTime(String time) {
		AppointmentDetails findAppointmentDetailsByAppTime = appRepo.findAppointmentDetailsByAppTime(time);

		Integer patientID = findAppointmentDetailsByAppTime.getUserID();
		// delete patient while deleting his appointment
//		patientService.deletePatientDetailsByID(patientID);

		AppointmentDetails appointmentDetails = new AppointmentDetails();
		appointmentDetails.setAppTimeStatue("Free");
		appointmentDetails.setAppID(findAppointmentDetailsByAppTime.getAppID());
		appointmentDetails.setAppTime(findAppointmentDetailsByAppTime.getAppTime());

		AppointmentDetails findById = appRepo.save(appointmentDetails);
		String message = "Not found";
		if (findById.getAppTimeStatue().equalsIgnoreCase("free")) {
			message = "Deleted";
		} else
			message = "Not found";
		return message;
	}

	public List<String> getFreeTimesSlotes() {
		return getAllAppointmentDetails().stream().filter(ap -> ap.getAppTimeStatue().equalsIgnoreCase("free"))
				.map(ap -> ap.getAppTime()).collect(Collectors.toList());
	}

	public AppointmentDetails getAppointmentDetailsByAppTime(String time) {
		AppointmentDetails appointmentDetails = new AppointmentDetails();
		List<AppointmentDetails> allAppointmentDetails = getAllAppointmentDetails();
		for (AppointmentDetails obj : allAppointmentDetails) {
			if (obj.getAppTime().equalsIgnoreCase(time)) {
				appointmentDetails = obj;
			}

		}
		return appointmentDetails;
	}

//	public AppointmentDetails getAppointmentByPatientID(Integer id) {
//		return appRepo.findAppointmentDetailsByAppTime(id);
//	}

	public String deleteAppointmentDetailsByID(Integer appID) {
		String message = "";
		Optional<AppointmentDetails> findAppointmentDetailsByAppTime = appRepo.findById(appID);

		if (findAppointmentDetailsByAppTime.isPresent()) {
			appRepo.deleteById(findAppointmentDetailsByAppTime.get().getAppID());
			message = "Deleted";
		}
		message = "Not found";
		return message;
	}

	public AppointmentDetails fetchAppointmentDetailsByAppTime(String time) {
		return appRepo.findAppointmentDetailsByAppTime(time);
	}
}
