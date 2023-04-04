package com.bs.webController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beans.AppointmentDetails;
import com.bs.beans.ICUDetails;
import com.bs.service.DoctorService;
import com.bs.service.ICU_Service;

@Controller
public class ICU_Controller {

	@Autowired
	private ICU_Service icuService;
	@Autowired
	private DoctorService doctorService;

	@GetMapping("/getICUList")
	public ModelAndView getICUList() {
		ModelAndView mav = new ModelAndView("ICU_List");
		List<ICUDetails> ICU_List = icuService.getAllICUDetails();
		System.out.println("######## List size:" + ICU_List);
		mav.addObject("empList", ICU_List);
		return mav;
	}

	@GetMapping("/upddateByBedNumber/{time}")
	public ModelAndView getAppointmentByID(@PathVariable("time") Integer id) {
		ModelAndView mav = new ModelAndView("UpdateICU_Details");
		ICUDetails icu_by_bed_number = icuService.getICUDetailsByBedNumber(id);
		System.out.println("PAtient of bed number :" + id + ":" + icu_by_bed_number);
		mav.addObject("app", icu_by_bed_number);

		List<Integer> freeBeds = icuService.getFreeBeds();
		System.out.println("Free beds count:" + freeBeds);
		mav.addObject("freeBeds", freeBeds);
		mav.addObject("bloodGroups", Arrays.asList("O +ve", "O -ve", "A +ve", "A -ve", "B -ve", "B +ve"));
		mav.addObject("doctorList",
				doctorService.getAllDoctorDetails().stream().map(doc -> doc.getDocName()).collect(Collectors.toList()));

		return mav;
	}

	@GetMapping("/freeBed/{bedNumber}")
	public ModelAndView freeBed(@PathVariable("bedNumber") Integer bedNumber) {
		ModelAndView mav = new ModelAndView("ICU_List");
		String message = icuService.deleteICUDetailsByBedNumer(bedNumber);

		if (message.equalsIgnoreCase("Not found"))
			mav.setViewName("FailureMessage");
		else if (message.equalsIgnoreCase("deleted")) {
			mav.setViewName("ICU_List");
			mav.addObject("empList", icuService.getAllICUDetails());
		}
		return mav;
	}

	@GetMapping("/dischargeByBedNumber/{bedNumber}")
	public ModelAndView dischargeByBedNumber(@PathVariable("bedNumber") Integer bedNumber) {
		ModelAndView mav = new ModelAndView("DischargeICU_Details");
		String message = icuService.dischargeByBedNumber(bedNumber);

		String message1 = icuService.deleteICUDetailsByBedNumer(bedNumber);
		if (message.equalsIgnoreCase("Not found"))
			mav.setViewName("FailureMessage");
		else if (message.equalsIgnoreCase("deleted")) {
			mav.setViewName("ICU_List");
			mav.addObject("empList", icuService.getAllICUDetails());
		}
		return mav;
	}

	@PostMapping("/updateICUDetails")
	public ModelAndView updateICUDetails(@ModelAttribute("app") ICUDetails userDetails) {
		System.out.println("ICU_Controller.updateICUDetails()");
		System.out.println("ICU: " + userDetails);
		icuService.updateICUDetails(userDetails);
		ModelAndView mav = new ModelAndView("ICU_List");
		mav.addObject("empList", icuService.getAllICUDetails());
		mav.addObject("doctorList",
				doctorService.getAllDoctorDetails().stream().map(doc -> doc.getDocName()).collect(Collectors.toList()));
		return mav;
	}

	@GetMapping("/loadICUPage")
	public ModelAndView loadICUPage() {
		ModelAndView mav = new ModelAndView("NewICU_Details");
		mav.addObject("app", new ICUDetails());

		List<Integer> freeBeds = icuService.getFreeBeds();
		System.out.println("Free beds count:" + freeBeds);
		mav.addObject("freeBeds", freeBeds);
		mav.addObject("bloodGroups", Arrays.asList("O +ve", "O -ve", "A +ve", "A -ve", "B -ve", "B +ve"));
		mav.addObject("doctorList",
				doctorService.getAllDoctorDetails().stream().map(doc -> doc.getDocName()).collect(Collectors.toList()));
		return mav;
	}

	@PostMapping("/createICUDetails")
	public ModelAndView createICUDetails(@ModelAttribute("app") ICUDetails userDetails) {
		// call patient service to fill other patient details
//		helperService.addPatientDetailsFromAppointment(userDetails);
//		appointmentServices.createAppointmentDetails(userDetails);
		icuService.createICUDetails(userDetails);
		ModelAndView mav = new ModelAndView("ICU_List");
		mav.addObject("empList", icuService.getAllICUDetails());
		return mav;
	}

//	@GetMapping("/DeleteByBedNumber")
//	public ModelAndView DeleteByBedNumber() {
//		ModelAndView mav = new ModelAndView("DeleteAppointmentsPage");
//		mav.addObject("empList", icuService.getAllAppointmentDetails().stream()
//				.filter(ss -> ss.getAppTimeStatue().equalsIgnoreCase("booked")).collect(Collectors.toList()));
//		return mav;
//	}
}
