package com.bs.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bs.beans.UserDetails;
import com.bs.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userServices;

	@PostMapping("/createUserDetails")
	public UserDetails createUserDetails(@RequestBody UserDetails userDetails) {
		return userServices.createUserDetails(userDetails);
	}

	public UserDetails updateUserDetails(UserDetails userDetails) {
		return userServices.updateUserDetails(userDetails);
	}

	@GetMapping("/getUserDetailsByID/{id}")
	public UserDetails getUserDetailsByID(@PathVariable("id") Integer id) {
		return userServices.getUserDetailsByID(id);
	}

	@GetMapping("/getAllUserDetails")
	public List<UserDetails> getAllUserDetails() {
		return userServices.getAllUserDetails();
	}

}
