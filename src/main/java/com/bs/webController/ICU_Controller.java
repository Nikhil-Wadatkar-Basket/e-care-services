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
import com.bs.exception.MyRuntimeException;
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
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("ICU_List");
		List<ICUDetails> ICU_List = null;

		try {
			ICU_List = icuService.getAllICUDetails();
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
		System.out.println("######## List size:" + ICU_List);
		mav.addObject("empList", ICU_List);
		return mav;
	}

	@GetMapping("/upddateByBedNumber/{time}")
	public ModelAndView getAppointmentByID(@PathVariable("time") Integer id) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("UpdateICU_Details");
		ICUDetails icu_by_bed_number = null;
		List<Integer> freeBeds = null;

		try {
			icu_by_bed_number = icuService.getICUDetailsByBedNumber(id);
			freeBeds = icuService.getFreeBeds();
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}

		mav.addObject("app", icu_by_bed_number);
		mav.addObject("freeBeds", freeBeds);
		mav.addObject("bloodGroups", Arrays.asList("O +ve", "O -ve", "A +ve", "A -ve", "B -ve", "B +ve"));
		mav.addObject("doctorList",
				doctorService.getAllDoctorDetails().stream().map(doc -> doc.getDocName()).collect(Collectors.toList()));

		return mav;
	}

	@GetMapping("/freeBed/{bedNumber}")
	public ModelAndView freeBed(@PathVariable("bedNumber") Integer bedNumber) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("ICU_List");
		String message = null;
		try {
			message = icuService.deleteICUDetailsByBedNumer(bedNumber);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}

		mav.setViewName("ICU_List");
		mav.addObject("empList", icuService.getAllICUDetails());
		return mav;
	}

	@GetMapping("/dischargeByBedNumber/{bedNumber}")
	public ModelAndView dischargeByBedNumber(@PathVariable("bedNumber") Integer bedNumber) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("DischargeICU_Details");
		try {
			String message = icuService.dischargeByBedNumber(bedNumber);

			String message1 = icuService.deleteICUDetailsByBedNumer(bedNumber);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
		mav.setViewName("ICU_List");
		mav.addObject("empList", icuService.getAllICUDetails());
		return mav;
	}

	@PostMapping("/updateICUDetails")
	public ModelAndView updateICUDetails(@ModelAttribute("app") ICUDetails userDetails) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

		try {
			icuService.updateICUDetails(userDetails);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}

		ModelAndView mav = new ModelAndView("ICU_List");
		mav.addObject("empList", icuService.getAllICUDetails());
		mav.addObject("doctorList",
				doctorService.getAllDoctorDetails().stream().map(doc -> doc.getDocName()).collect(Collectors.toList()));
		return mav;
	}

	@GetMapping("/loadICUPage")
	public ModelAndView loadICUPage() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("NewICU_Details");
		List<Integer> freeBeds = null;

		try {
			freeBeds = icuService.getFreeBeds();
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}

		mav.addObject("app", new ICUDetails());
		mav.addObject("freeBeds", freeBeds);
		mav.addObject("bloodGroups", Arrays.asList("O +ve", "O -ve", "A +ve", "A -ve", "B -ve", "B +ve"));
		mav.addObject("doctorList",
				doctorService.getAllDoctorDetails().stream().map(doc -> doc.getDocName()).collect(Collectors.toList()));
		return mav;
	}

	@PostMapping("/createICUDetails")
	public ModelAndView createICUDetails(@ModelAttribute("app") ICUDetails userDetails) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

//		call patient service to fill other patient details
//		helperService.addPatientDetailsFromAppointment(userDetails);
//		appointmentServices.createAppointmentDetails(userDetails);

		try {
			icuService.createICUDetails(userDetails);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
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
