package com.bs.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.AppointmentDetails;
import com.bs.beans.PatientDetails;
import com.bs.repo.PatientRepo;

@Service
public class PatientService {

	@Autowired
	private PatientRepo patientRepo;

	@Transactional
	public PatientDetails createPatientDetails(PatientDetails patientDetails) {
		return patientRepo.save(patientDetails);
	}

	public PatientDetails updatePatientDetails(PatientDetails patientDetails) {
		PatientDetails updated = null;
		Optional<PatientDetails> existedPatientDetails = patientRepo.findById(patientDetails.getPatientID());
		if (existedPatientDetails.isPresent()) {
			PatientDetails patientDetails2 = existedPatientDetails.get();
			updated=patientRepo.save(patientDetails);
		}
		return updated;
	}

	public PatientDetails getPatientDetailsByID(Integer id) {
		Optional<PatientDetails> findById = patientRepo.findById(id);
		if (findById.isPresent())
			return findById.get();
		else
			return null;
	}

	public List<PatientDetails> getAllPatientDetails() {
		return patientRepo.findAll();
	}
	public String deletePatientDetailsByID(Integer id) {
		Optional<PatientDetails> findById = patientRepo.findById(id);
		String message = "Not found";
		if (findById.isPresent()) {
			patientRepo.deleteById(id);
			message = "Deleted";
		} else
			message = "Not found";
		return message;
	}

}
