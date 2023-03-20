package com.bs.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bs.beans.DoctorDetails;
import com.bs.service.DoctorService;

@RestController
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@GetMapping("/getDoctor")
	public DoctorDetails get() {
		return new DoctorDetails(12,"Dr. Pathak","MD","123",123);
	}

	@PostMapping("/createDoctorDetails")
	public DoctorDetails createDoctorDetails(@RequestBody DoctorDetails doctorDetails) {
		return doctorService.createDoctorDetails(doctorDetails);
	}

	public DoctorDetails updateDoctorDetails(DoctorDetails doctorDetails) {
		return doctorService.updateDoctorDetails(doctorDetails);
	}

	@GetMapping("/getDoctorDetailsByID/{id}")
	public DoctorDetails getDoctorDetailsByID(@PathVariable("id") Integer id) {
		return doctorService.getDoctorDetailsByID(id);
	}

	@GetMapping("/getAllDoctorDetails")
	public List<DoctorDetails> getAllDoctorDetails() {
		return doctorService.getAllDoctorDetails();
	}

}
