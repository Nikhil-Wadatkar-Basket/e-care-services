package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.UserDetails;
import com.bs.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public UserDetails createUserDetails(UserDetails userDetails) {
		return userRepo.save(userDetails);
	}

	public UserDetails updateUserDetails(UserDetails userDetails) {
		UserDetails updated = null;
		Optional<UserDetails> existedUserDetails = userRepo.findById(userDetails.getUserID());
		if (existedUserDetails.isPresent()) {
			UserDetails userDetails2 = existedUserDetails.get();

		}
		return updated;
	}

	public UserDetails getUserDetailsByID(Integer id) {
		Optional<UserDetails> findById = userRepo.findById(id);
		if (findById.isPresent())
			return findById.get();
		else
			return null;
	}

	public List<UserDetails> getAllUserDetails() {
		return userRepo.findAll();
	}

}
