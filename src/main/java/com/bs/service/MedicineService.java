package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.MedicineDetails;
import com.bs.repo.MedicineRepo;

@Service
public class MedicineService {

	@Autowired
	private MedicineRepo medicineRepo;

	public MedicineDetails createMedicineDetails(MedicineDetails medicineDetails) {
		return medicineRepo.save(medicineDetails);
	}

	public MedicineDetails updateMedicineDetails(MedicineDetails medicineDetails) {
		MedicineDetails updated = null;
		Optional<MedicineDetails> existedMedicineDetails = medicineRepo.findById(medicineDetails.getMedicineID());
		if (existedMedicineDetails.isPresent()) {
			MedicineDetails medicineDetails2 = existedMedicineDetails.get();
			updated=medicineRepo.save(medicineDetails);
		}
		return updated;
	}

	public MedicineDetails getMedicineDetailsByID(Integer id) {
		Optional<MedicineDetails> findById = medicineRepo.findById(id);
		if (findById.isPresent())
			return findById.get();
		else
			return null;
	}

	public List<MedicineDetails> getAllMedicineDetails() {
		return medicineRepo.findAll();
	}
	public String deleteMedicineDetailsByID(Integer id) {
		Optional<MedicineDetails> findById = medicineRepo.findById(id);
		String message = "Not found";
		if (findById.isPresent()) {
			medicineRepo.deleteById(id);
			message = "Deleted";
		} else
			message = "Not found";
		return message;
	}

}
