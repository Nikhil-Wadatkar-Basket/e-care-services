package com.bs.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bs.beans.MedicineDetails;
import com.bs.service.MedicineService;

@RestController
public class MedicineController {
	@Autowired
	private MedicineService medicineServices;

	@PostMapping("/createMedicineDetails")
	public MedicineDetails createMedicineDetails(@RequestBody MedicineDetails medicineDetails) {
		return medicineServices.createMedicineDetails(medicineDetails);
	}

	public MedicineDetails updateMedicineDetails(MedicineDetails medicineDetails) {
		return medicineServices.updateMedicineDetails(medicineDetails);
	}

	@GetMapping("/getMedicineDetailsByID/{id}")
	public MedicineDetails getMedicineDetailsByID(@PathVariable("id") Integer id) {
		return medicineServices.getMedicineDetailsByID(id);
	}

	@GetMapping("/getAllMedicineDetails")
	public List<MedicineDetails> getAllMedicineDetails() {
		return medicineServices.getAllMedicineDetails();
	}

}
