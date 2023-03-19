package com.bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.beans.UserDetails;
import com.bs.service.UserService;

public class UserController {
	@Autowired
	private UserService userServices;

	public UserDetails createUserDetails(UserDetails userDetails) {
		return userServices.createUserDetails(userDetails);
	}

	public UserDetails updateUserDetails(UserDetails userDetails) {
		return userServices.updateUserDetails(userDetails);
	}

	public UserDetails getUserDetailsByID(Integer id) {
		return userServices.getUserDetailsByID(id);
	}

	public List<UserDetails> getAllUserDetails() {
		return userServices.getAllUserDetails();
	}

}
