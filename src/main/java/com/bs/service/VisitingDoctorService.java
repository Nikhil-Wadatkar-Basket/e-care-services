package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.VisitingDoctorDetails;
import com.bs.repo.VisitingDoctorRepo;

@Service
public class VisitingDoctorService {

	@Autowired
	private VisitingDoctorRepo userRepo;

	public VisitingDoctorDetails createVisitingDoctorDetails(VisitingDoctorDetails doctorDetails) {

		VisitingDoctorDetails savedVisitingDoctor = userRepo.save(doctorDetails);
		System.out.println("Saved with " + savedVisitingDoctor);
		return savedVisitingDoctor;
	}

	public VisitingDoctorDetails updateVisitingDoctorDetails(VisitingDoctorDetails doctorDetails) {
		VisitingDoctorDetails updated = null;
		Optional<VisitingDoctorDetails> existedVisitingDoctorDetails = userRepo.findById(doctorDetails.getDocID());
		if (existedVisitingDoctorDetails.isPresent()) {
			VisitingDoctorDetails doctorDetails2 = existedVisitingDoctorDetails.get();
			updated = userRepo.save(doctorDetails);
		}
		return updated;
	}

	public VisitingDoctorDetails getVisitingDoctorDetailsByID(Integer id) {
		Optional<VisitingDoctorDetails> findById = userRepo.findById(id);
		if (findById.isPresent())
			return findById.get();
		else
			return null;
	}

	public List<VisitingDoctorDetails> getAllVisitingDoctorDetails() {
		return userRepo.findAll();
	}

	public String deleteVisitingDoctorDetailsByID(Integer id) {
		Optional<VisitingDoctorDetails> findById = userRepo.findById(id);
		String message = "Not found";
		if (findById.isPresent()) {
			userRepo.deleteById(id);
			message = "Deleted";
		} else
			message = "Not found";
		return message;
	}

}
