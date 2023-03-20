package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.AppointmentDetails;
import com.bs.repo.AppointmentRepo;
import com.bs.repo.UserRepo;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepo appRepo;

	public AppointmentDetails createAppointmentDetails(AppointmentDetails appointmentDetails) {
		return appRepo.save(appointmentDetails);
	}

	public AppointmentDetails updateAppointmentDetails(AppointmentDetails appointmentDetails) {
		AppointmentDetails updated = null;
		Optional<AppointmentDetails> existedAppointmentDetails = appRepo.findById(appointmentDetails.getAppID());
		if (existedAppointmentDetails.isPresent()) {
			AppointmentDetails userDetails2 = existedAppointmentDetails.get();
			updated = appRepo.save(appointmentDetails);
		}
		return updated;
	}

	public AppointmentDetails getAppointmentDetailsByID(Integer id) {
		Optional<AppointmentDetails> findById = appRepo.findById(id);
		if (findById.isPresent())
			return findById.get();
		else
			return null;
	}

	public List<AppointmentDetails> getAllAppointmentDetails() {
		return appRepo.findAll();
	}

	public String deleteAppointmentDetailsByID(Integer id) {
		Optional<AppointmentDetails> findById = appRepo.findById(id);
		String message = "Not found";
		if (findById.isPresent()) {
			appRepo.deleteById(id);
			message = "Deleted";
		} else
			message = "Not found";
		return message;
	}

}
