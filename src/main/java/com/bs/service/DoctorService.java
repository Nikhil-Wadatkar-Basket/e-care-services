package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.DoctorDetails;
import com.bs.repo.DoctorRepo;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepo userRepo;

	public DoctorDetails createDoctorDetails(DoctorDetails doctorDetails) {
		DoctorDetails details = new DoctorDetails();
		details.setDesignation(doctorDetails.getDesignation());
		details.setDocContact(doctorDetails.getDocContact());
		details.setDocName(doctorDetails.getDocName());
		return userRepo.save(details);
	}

	public DoctorDetails updateDoctorDetails(DoctorDetails doctorDetails) {
		DoctorDetails updated = null;
		Optional<DoctorDetails> existedDoctorDetails = userRepo.findById(doctorDetails.getDocID());
		if (existedDoctorDetails.isPresent()) {
			DoctorDetails doctorDetails2 = existedDoctorDetails.get();
			updated = userRepo.save(doctorDetails);
		}
		return updated;
	}

	public DoctorDetails getDoctorDetailsByID(Integer id) {
		Optional<DoctorDetails> findById = userRepo.findById(id);
		if (findById.isPresent())
			return findById.get();
		else
			return null;
	}

	public List<DoctorDetails> getAllDoctorDetails() {
		return userRepo.findAll();
	}

	public String deleteDoctorDetailsByID(Integer id) {
		Optional<DoctorDetails> findById = userRepo.findById(id);
		String message = "Not found";
		if (findById.isPresent()) {
			userRepo.deleteById(id);
			message = "Deleted";
		} else
			message = "Not found";
		return message;
	}

}
