package com.bs.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bs.beans.AppointmentDetails;
import com.bs.service.AppointmentService;

@RestController
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentServices;

	@GetMapping("/getAppointmentDetails")
	public AppointmentDetails get() {
		AppointmentDetails appointmentDetails = new AppointmentDetails();
		appointmentDetails.setAppTimeStatue("free");
		return appointmentDetails;
	}

	@PostMapping("/createAppointmentDetails")
	public AppointmentDetails createAppointmentDetails(@RequestBody AppointmentDetails userDetails) {
		return appointmentServices.createAppointmentDetails(userDetails);
	}

	@PutMapping("/updateAppointmentDetails")
	public AppointmentDetails updateAppointmentDetails(AppointmentDetails userDetails) {
		return appointmentServices.updateAppointmentDetails(userDetails);
	}

	@GetMapping("/getAppointmentDetailsByID")
	public AppointmentDetails getAppointmentDetailsByID(Integer id) {
		return appointmentServices.getAppointmentDetailsByID(id);
	}

	@GetMapping("/getAllAppointmentDetails")
	public List<AppointmentDetails> getAllAppointmentDetails() {
		return appointmentServices.getAllAppointmentDetails();
	}

}
