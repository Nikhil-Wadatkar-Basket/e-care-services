package com.bs.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.beans.AppointmentDetails;
import com.bs.service.AppointmentService;

@RestController
public class ResetConfig {
	@Autowired
	private AppointmentService appointmentService;

	@GetMapping("/setAll")
	public String setAll() {
		List<String> times = appointmentService.getAllAppointmentDetails().stream().map(dd -> dd.getAppTime())
				.collect(Collectors.toList());
		AppointmentDetails appointmentDetails = new AppointmentDetails();

		times.forEach(tim -> {
			appointmentDetails.setAppTime(tim);
			appointmentDetails.setAppTimeStatue("Free");
			appointmentService.createAppointmentDetails(appointmentDetails);
		});
		return "Saved";
	}
}
