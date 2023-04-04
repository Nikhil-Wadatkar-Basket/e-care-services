package com.bs.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bs.beans.MedicinePatient;
import com.bs.service.MedicinePatientService;

@RestController
public class MadicinePatientController {
	@Autowired
	private MedicinePatientService appointmentServices;

	@GetMapping("/getMedicinePatient")
	public MedicinePatient get() {
		MedicinePatient appointmentDetails = new MedicinePatient();
		return appointmentDetails;
	}

	@PostMapping("/createMedicinePatient")
	public MedicinePatient createMedicinePatient(@RequestBody MedicinePatient userDetails) {
		return appointmentServices.createMedicinePatient(userDetails);
	}

	@PutMapping("/updateMedicinePatient")
	public MedicinePatient updateMedicinePatient(MedicinePatient userDetails) {
		return appointmentServices.updateMedicinePatient(userDetails);
	}

	@GetMapping("/getMedicinePatientByID")
	public MedicinePatient getMedicinePatientByID(Integer id) {
		return appointmentServices.getMedicinePatientByID(id);
	}

	@GetMapping("/getAllMedicinePatient")
	public List<MedicinePatient> getAllMedicinePatient() {
		return appointmentServices.getAllMedicinePatient();
	}

}
