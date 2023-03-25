package com.bs.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bs.beans.PatientDetails;
import com.bs.service.PatientService;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientServices;

	@PostMapping("/createPatientDetails")
	public PatientDetails createPatientDetails(@RequestBody PatientDetails patientDetails) {
		return patientServices.createPatientDetails(patientDetails);
	}

	public PatientDetails updatePatientDetails(PatientDetails patientDetails) {
		return patientServices.updatePatientDetails(patientDetails);
	}

	@GetMapping("/getPatientDetailsByID/{id}")
	public PatientDetails getPatientDetailsByID(@PathVariable("id") Integer id) {
		return patientServices.getPatientDetailsByID(id);
	}

	@GetMapping("/getAllPatientDetails")
	public List<PatientDetails> getAllPatientDetails() {
		return patientServices.getAllPatientDetails();
	}

}
