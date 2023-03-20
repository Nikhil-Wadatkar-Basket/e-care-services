package com.bs.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beans.AppointmentDetails;
import com.bs.beans.DoctorDetails;
import com.bs.service.AppointmentService;
import com.bs.service.DoctorService;

@Controller
public class WebController {
	@Autowired
	private AppointmentService appointmentServices;

	@Autowired
	private DoctorService docServices;

	@GetMapping("/demo")
	public String demo() {
		return "SuccessMessage";
	}

	@GetMapping("/getAppointmentsList")
	public ModelAndView getAppointmentsList() {
		ModelAndView mav = new ModelAndView("AppointmentsList");
		mav.addObject("empList", appointmentServices.getAllAppointmentDetails());
		return mav;
	}

	@GetMapping("/getAppointmentByID/{id}")
	public ModelAndView getAppointmentByID(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("AppointmentsList");

		AppointmentDetails appointmentDetailsByID = appointmentServices.getAppointmentDetailsByID(id);
		mav.addObject("app", appointmentDetailsByID);

		mav.setViewName("UpdateAppointment");
		return mav;
	}

	@GetMapping("/deleteAppointment/{id}")
	public ModelAndView deleteAppointment(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("AppointmentsList");
		String message = appointmentServices.deleteAppointmentDetailsByID(id);

		if (message.equalsIgnoreCase("Not found"))
			mav.setViewName("FailureMessage");
		else if (message.equalsIgnoreCase("deleted"))
			mav.setViewName("SuccessMessage");
//		mav.addObject("empList", appointmentServices.getAllAppointmentDetails());
		return mav;
	}

	@PostMapping("/updateAppointment")
	public ModelAndView updateAppointmentDetails(@ModelAttribute("app") AppointmentDetails userDetails) {
		appointmentServices.updateAppointmentDetails(userDetails);
		ModelAndView mav = new ModelAndView("AppointmentsList");
		mav.addObject("empList", appointmentServices.getAllAppointmentDetails());
		return mav;
	}

	@GetMapping("/loadNewAppointmentPage")
	public ModelAndView loadNewAppointmentPage() {
		ModelAndView mav = new ModelAndView("NewAppointment");
		mav.addObject("app", new AppointmentDetails());
		mav.addObject("doctorList", Arrays.asList("Dr. Pathak", "Dr. Kedar"));
		return mav;
	}

	@PostMapping("/createNewAppointment")
	public ModelAndView createNewAppointment(@ModelAttribute("app") AppointmentDetails userDetails) {
		// call patient service to fill other patient details

		appointmentServices.createAppointmentDetails(userDetails);
		ModelAndView mav = new ModelAndView("AppointmentsList");
		mav.addObject("empList", appointmentServices.getAllAppointmentDetails());
		return mav;
	}

	@GetMapping("/DeleteAppointmentsPage")
	public ModelAndView deleteAppointmentsPage() {
		ModelAndView mav = new ModelAndView("DeleteAppointmentsPage");
		mav.addObject("empList", appointmentServices.getAllAppointmentDetails());
		return mav;
	}

	// -----------------------doctor
	@GetMapping("/showDoctors")
	public ModelAndView showDoctors() {
		ModelAndView mav = new ModelAndView("DoctorList");
		mav.addObject("empList", docServices.getAllDoctorDetails());
		return mav;
	}

	@GetMapping("/loadNewDoctorPage")
	public ModelAndView loadNewDoctorPage() {
		ModelAndView mav = new ModelAndView("NewDoctor");
		mav.addObject("doc", new DoctorDetails());
		mav.addObject("designationList", Arrays.asList("MD", "MBBS", "MS"));
		return mav;
	}

	@PostMapping("/createDoctor")
	public ModelAndView createDoctor(@ModelAttribute("doc") DoctorDetails doctor) {
		docServices.createDoctorDetails(doctor);
		ModelAndView mav = new ModelAndView("DoctorList");
		mav.addObject("empList", docServices.getAllDoctorDetails());
		return mav;
	}

	@PostMapping("/updateDoctor")
	public ModelAndView updateDoctor(@ModelAttribute("doc") DoctorDetails doctor) {
		docServices.updateDoctorDetails(doctor);

		ModelAndView mav = new ModelAndView("DeleteDoctorPage");
		mav.addObject("empList", docServices.getAllDoctorDetails());
		return mav;
	}

	@GetMapping("/getDoctor/{id}")
	public ModelAndView getDoctor(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("DoctorList");
		DoctorDetails doctorDetailsByID = docServices.getDoctorDetailsByID(id);
		mav.addObject("doc", doctorDetailsByID);
		mav.setViewName("UpdateDoctor");
		return mav;
	}

	@GetMapping("/DeleteDoctorPage")
	public ModelAndView DeleteDoctorPage() {
		ModelAndView mav = new ModelAndView("DeleteDoctorPage");
		mav.addObject("empList", docServices.getAllDoctorDetails());
		return mav;
	}

	@GetMapping("/deleteDoctor/{id}")
	public ModelAndView deleteDoctor(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("DoctorList");
		String message = docServices.deleteDoctorDetailsByID(id);

		if (message.equalsIgnoreCase("Not found"))
			mav.setViewName("FailureMessage");
		else if (message.equalsIgnoreCase("deleted"))
			mav.setViewName("SuccessMessage");
//		mav.addObject("empList", appointmentServices.getAllAppointmentDetails());
		return mav;
	}

	@GetMapping("/getDoctorByID/{id}")
	public ModelAndView getDoctorByID(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("DoctorList");

		DoctorDetails appointmentDetailsByID = docServices.getDoctorDetailsByID(id);
		mav.addObject("app", appointmentDetailsByID);

		mav.setViewName("UpdateDoctor");
		return mav;
	}
}
