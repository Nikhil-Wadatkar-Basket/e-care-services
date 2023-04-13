package com.bs.webController;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beans.FeedbackDetails;
import com.bs.beans.UserDetails;
import com.bs.repo.FeedbackRepo;
import com.bs.repo.MedicinePatientRepo;
import com.bs.repo.MedicineRepo;
import com.bs.repo.UserRepo;
import com.bs.repo.VisitingDoctorRepo;

@RestController
public class UserController {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private MedicineRepo medicineRepo;
	@Autowired
	private FeedbackRepo feedbackRepo;

	@Autowired
	private MedicinePatientRepo medicinePatientRepo;
	@Autowired
	private VisitingDoctorRepo visitingDoctorRepo;

	@GetMapping("/login")
	public ModelAndView login(UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("LoginPage");
		modelAndView.addObject("userDetails", new UserDetails());
		return modelAndView;
	}

	@PostMapping("/authenticate")
	public ModelAndView authenticate(@ModelAttribute("userDetails") UserDetails userDetails) {
		userDetails.setRole("User");
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(userDetails);
		UserDetails findByUserNameAndPassword = userRepo.findUserDetailsByUserNameAndPassword(userDetails.getUserName(),
				userDetails.getPassword());

		System.out.println("Result:" + findByUserNameAndPassword);
		if (null != findByUserNameAndPassword && findByUserNameAndPassword.getUserName() != null
				&& findByUserNameAndPassword.getPassword() != null)
			modelAndView.setViewName("Dashboard");
		else
			modelAndView.setViewName("ErrorLoginPage");

		return modelAndView;
	}

	@GetMapping("/showUsers")
	public ModelAndView showMedicines() {
		ModelAndView mav = new ModelAndView("UsersList");
		mav.addObject("empList", userRepo.findAll());
		return mav;
	}

	@GetMapping("/loadNewUserPage")
	public ModelAndView loadNewUserPage() {
		ModelAndView mav = new ModelAndView("NewUserPage");
		mav.addObject("user", new UserDetails());
		mav.addObject("rolesList", Arrays.asList("ADMIN", "USER"));
		return mav;
	}

	@PostMapping("/createUser")
	public ModelAndView createUser(@ModelAttribute("medicine") UserDetails userDetails) {
		UserDetails details = new UserDetails();
		details.setCity(userDetails.getCity());
		details.setEmail(userDetails.getEmail());
		details.setName(userDetails.getName());
		details.setPassword(userDetails.getPassword());
		details.setRole(userDetails.getRole());
		details.setStatus(userDetails.getStatus());
		details.setUserName(userDetails.getUserName());

		try {
			userRepo.save(details);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("UsersList");
		mav.addObject("empList", userRepo.findAll());
		return mav;
	}

	@PostMapping("/updateUser")
	public ModelAndView updateUser(@ModelAttribute("user") UserDetails userDetails, Object medicineService) {
		userRepo.save(userDetails);

		ModelAndView mav = new ModelAndView("UsersList");
		mav.addObject("empList", userRepo.findAll());
		return mav;
	}

	@GetMapping("/getUser/{id}")
	public ModelAndView getMedicineByID(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("UsersList");
		UserDetails medicinerDetailsByID = userRepo.findById(id).get();
		mav.addObject("user", medicinerDetailsByID);
		mav.addObject("rolesList", Arrays.asList("ADMIN", "USER"));
		mav.setViewName("UpdateUser");
		return mav;
	}
//
//	@GetMapping("/DeleteMedicinePage")
//	public ModelAndView DeleteMedicinePage() {
//		ModelAndView mav = new ModelAndView("DeleteMedicinesPage");
//		mav.addObject("empList", medicineService.getAllMedicineDetails());
//		return mav;
//	}

	@GetMapping("/deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable("id") Integer id) {
		userRepo.deleteById(id);
		ModelAndView mav = new ModelAndView("UsersList");
		mav.addObject("empList", userRepo.findAll());

		return mav;
	}
//--------------------------------------------------------------

	@GetMapping("/Dashboard")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("Dashboard");
		return modelAndView;
	}

	@GetMapping("/AppointmentDashboard")
	public ModelAndView AppointmentDashboard() {
		ModelAndView modelAndView = new ModelAndView("AppointmentDashboard");
		return modelAndView;
	}

	@GetMapping("/DoctorDashboard")
	public ModelAndView DoctorDashboard() {
		ModelAndView modelAndView = new ModelAndView("DoctorDashboard");
		return modelAndView;
	}

	@GetMapping("/PatientDashboard")
	public ModelAndView PatientDashboard() {
		ModelAndView modelAndView = new ModelAndView("PatientDashboard");
		return modelAndView;
	}

	@GetMapping("/VisitorsDoctorDashboard")
	public ModelAndView VisitorsDoctorDashboard() {
		ModelAndView modelAndView = new ModelAndView("VisitorsDoctorDashboard");
		return modelAndView;
	}

	@GetMapping("/MedicineDashboard")
	public ModelAndView MedicineDashboard() {
		ModelAndView modelAndView = new ModelAndView("MedicineDashboard");
		return modelAndView;
	}

	@GetMapping("/PharmacyDashboard")
	public ModelAndView PharmacyDashboard() {
		ModelAndView modelAndView = new ModelAndView("MedicinesList2");
		return modelAndView;
	}

	@GetMapping("/MedicineCounterDashboard")
	public ModelAndView MedicineCounterDashboard() {
		ModelAndView modelAndView = new ModelAndView("MedicineCounterDashboard");
		return modelAndView;
	}

	@GetMapping("/MedicinePatientsList")
	public ModelAndView MedicinePatientsList() {
		ModelAndView modelAndView = new ModelAndView("MedicinePatientsList");
		modelAndView.addObject("empList", medicinePatientRepo.findAll());
		return modelAndView;
	}

	@GetMapping("/newFeedbackPage")
	public ModelAndView newFeedbackPage() {
		ModelAndView modelAndView = new ModelAndView("NewFeedback");
		modelAndView.addObject("doc", new FeedbackDetails());
		return modelAndView;
	}

	@PostMapping("/createFeedback")
	public ModelAndView createFeedback(@ModelAttribute("doc") FeedbackDetails details) {
		feedbackRepo.save(details);
		ModelAndView modelAndView = new ModelAndView("FeedbackList");
		modelAndView.addObject("empList", feedbackRepo.findAll());
		return modelAndView;
	}

	@GetMapping("/feedbacks")
	public ModelAndView feedbacks() {
		ModelAndView modelAndView = new ModelAndView("FeedbackList");
		modelAndView.addObject("empList", feedbackRepo.findAll());
		return modelAndView;
	}

}
