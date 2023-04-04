package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.MedicinePatient;
import com.bs.repo.MedicinePatientRepo;

@Service
public class MedicinePatientService {

	@Autowired
	private MedicinePatientRepo repo;

	public MedicinePatient createMedicinePatient(MedicinePatient medicineDetails) {
		return repo.save(medicineDetails);
	}

	public MedicinePatient updateMedicinePatient(MedicinePatient medicineDetails) {
		MedicinePatient updated = null;
		Optional<MedicinePatient> existedMedicinePatient = repo.findById(medicineDetails.getMediPatID());
		if (existedMedicinePatient.isPresent()) {
			MedicinePatient medicineDetails2 = existedMedicinePatient.get();
			updated = repo.save(medicineDetails);
		}
		return updated;
	}

	public MedicinePatient getMedicinePatientByID(Integer id) {
		Optional<MedicinePatient> findById = repo.findById(id);
		if (findById.isPresent())
			return findById.get();
		else
			return null;
	}

	public List<MedicinePatient> getAllMedicinePatient() {
		return repo.findAll();
	}

	public String deleteMedicinePatientByID(Integer id) {
		Optional<MedicinePatient> findById = repo.findById(id);
		String message = "Not found";
		if (findById.isPresent()) {
			repo.deleteById(id);
			message = "Deleted";
		} else
			message = "Not found";
		return message;
	}

}
