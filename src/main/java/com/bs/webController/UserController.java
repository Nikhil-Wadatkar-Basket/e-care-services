package com.bs.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beans.UserDetails;
import com.bs.repo.MedicinePatientRepo;
import com.bs.repo.MedicineRepo;
import com.bs.repo.UserRepo;

@RestController
public class UserController {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private MedicineRepo medicineRepo;
	
	@Autowired
	private MedicinePatientRepo medicinePatientRepo;

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

	

}
