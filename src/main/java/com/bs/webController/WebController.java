package com.bs.webController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beans.AppointmentDetails;
import com.bs.beans.DoctorDetails;
import com.bs.beans.MedicineDetails;
import com.bs.beans.PatientDetails;
import com.bs.helper.HelperService;
import com.bs.repo.UserRepo;
import com.bs.service.AppointmentService;
import com.bs.service.DoctorService;
import com.bs.service.MedicineService;
import com.bs.service.PatientService;

@Controller
public class WebController {
	@Autowired
	private AppointmentService appointmentServices;

	@Autowired
	private DoctorService docServices;

	@Autowired
	private PatientService patientServices;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private MedicineService medicineService;
	@Autowired
	private HelperService helperService;

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

	@GetMapping("/getAppointmentByTime/{time}")
	public ModelAndView getAppointmentByID(@PathVariable("time") String id) {
		ModelAndView mav = new ModelAndView("AppointmentsList");

		AppointmentDetails appointmentDetailsByID = appointmentServices.getAppointmentDetailsByAppTime(id);
		mav.addObject("app", appointmentDetailsByID);
		mav.addObject("doctorList", getAvailableDoctors());
		List<String> freeTimeSlots = appointmentServices.getFreeTimesSlotes();
		mav.addObject("freeTimeSlots", freeTimeSlots);
		mav.addObject("bloodGroups", Arrays.asList("O +ve", "O -ve", "A +ve", "A -ve", "B -ve", "B +ve"));
		mav.setViewName("UpdateAppointment");
		return mav;
	}

	private List<String> getAvailableDoctors() {
		return docServices.getAllDoctorDetails().stream().map(doc -> doc.getDocName()).collect(Collectors.toList());
	}

	@GetMapping("/deleteAppointmentByTime/{time}")
	public ModelAndView deleteAppointment(@PathVariable("time") String id) {
		ModelAndView mav = new ModelAndView("AppointmentsList");
		String message = appointmentServices.deleteAppointmentDetailsByAppTime(id);

		if (message.equalsIgnoreCase("Not found"))
			mav.setViewName("FailureMessage");
		else if (message.equalsIgnoreCase("deleted")) {
			mav.setViewName("AppointmentsList");
			mav.addObject("empList", appointmentServices.getAllAppointmentDetails());
		}
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

		mav.addObject("doctorList", getAvailableDoctors());
		List<String> freeTimeSlots = appointmentServices.getFreeTimesSlotes();
		mav.addObject("freeTimeSlots", freeTimeSlots);
		mav.addObject("bloodGroups", Arrays.asList("O +ve", "O -ve", "A +ve", "A -ve", "B -ve", "B +ve"));

		return mav;
	}

	@PostMapping("/createNewAppointment")
	public ModelAndView createNewAppointment(@ModelAttribute("app") AppointmentDetails userDetails) {
		// call patient service to fill other patient details
		helperService.addPatientDetailsFromAppointment(userDetails);
//		appointmentServices.createAppointmentDetails(userDetails);
		ModelAndView mav = new ModelAndView("AppointmentsList");
		mav.addObject("empList", appointmentServices.getAllAppointmentDetails());
		return mav;
	}

	@GetMapping("/DeleteAppointmentsPage")
	public ModelAndView deleteAppointmentsPage() {
		ModelAndView mav = new ModelAndView("DeleteAppointmentsPage");
		mav.addObject("empList", appointmentServices.getAllAppointmentDetails().stream()
				.filter(ss -> ss.getAppTimeStatue().equalsIgnoreCase("booked")).collect(Collectors.toList()));
		return mav;
	}

	// -----------------------doctor------------------------------------------------------
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
			mav.setViewName("DoctorList");
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

	// ----------------------patient---------------------------
	@GetMapping("/showPatients")
	public ModelAndView showPatients() {
		ModelAndView mav = new ModelAndView("PatientsList");
		mav.addObject("empList", patientServices.getAllPatientDetails());
		return mav;
	}

	@GetMapping("/loadNewPatientPage")
	public ModelAndView loadNewPatientPage() {
		ModelAndView mav = new ModelAndView("NewPatient");

		mav.addObject("patient", new PatientDetails());
		mav.addObject("doctorList", getAvailableDoctors());
		List<String> freeTimeSlots = appointmentServices.getFreeTimesSlotes();
		mav.addObject("freeTimeSlots", freeTimeSlots);
		mav.addObject("bloodGroups", Arrays.asList("O +ve", "O -ve", "A +ve", "A -ve", "B -ve", "B +ve"));
		return mav;
	}

	@PostMapping("/createPatient")
	public ModelAndView createPatient(@ModelAttribute("patient") PatientDetails doctor) {
		PatientDetails patientID = patientServices.createPatientDetails(doctor);

		helperService.createAppointmentforPatient(patientID);
		ModelAndView mav = new ModelAndView("PatientsList");
		mav.addObject("empList", patientServices.getAllPatientDetails());
		return mav;
	}

	@PostMapping("/updatePatient")
	public ModelAndView updatePatient(@ModelAttribute("patient") PatientDetails doctor) {
		patientServices.updatePatientDetails(doctor);

		ModelAndView mav = new ModelAndView("PatientsList");
		mav.addObject("empList", patientServices.getAllPatientDetails());
		return mav;
	}

	@GetMapping("/getPatientByID/{id}")
	public ModelAndView getPatientByID(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("PatientsList");
		PatientDetails patientrDetailsByID = patientServices.getPatientDetailsByID(id);
		mav.addObject("patient", patientrDetailsByID);
		mav.addObject("doctorList", getAvailableDoctors());
		List<String> freeTimeSlots = appointmentServices.getFreeTimesSlotes();
		mav.addObject("freeTimeSlots", freeTimeSlots);
		mav.addObject("bloodGroups", Arrays.asList("O +ve", "O -ve", "A +ve", "A -ve", "B -ve", "B +ve"));
		mav.setViewName("UpdatePatient");
		return mav;
	}

	@GetMapping("/DeletePatientPage")
	public ModelAndView DeletePatientPage() {
		ModelAndView mav = new ModelAndView("DeletePatientsPage");
		mav.addObject("empList", patientServices.getAllPatientDetails());
		return mav;
	}

	@GetMapping("/deletePatient/{id}")
	public ModelAndView deletePatient(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("PatientsList");
		helperService.deletePatientsFromAppointment(id);
		String message = patientServices.deletePatientDetailsByID(id);
		if (message.equalsIgnoreCase("Not found"))
			mav.setViewName("FailureMessage");
		else if (message.equalsIgnoreCase("deleted")) {
			mav.setViewName("PatientsList");
			mav.addObject("empList", patientServices.getAllPatientDetails());
		}
		return mav;
	}
//------------medicine---------------------

	@GetMapping("/showMedicines")
	public ModelAndView showMedicines() {
		ModelAndView mav = new ModelAndView("MedicinesList");
		mav.addObject("empList", medicineService.getAllMedicineDetails());
		return mav;
	}

	@GetMapping("/loadNewMedicinePage")
	public ModelAndView loadNewMedicinePage() {
		ModelAndView mav = new ModelAndView("NewMedicine");
		mav.addObject("medicine", new MedicineDetails());
//				mav.addObject("designationList", Arrays.asList("MD", "MBBS", "MS"));
		return mav;
	}

	@PostMapping("/createMedicine")
	public ModelAndView createMedicine(@ModelAttribute("medicine") MedicineDetails doctor) {
		medicineService.createMedicineDetails(doctor);
		ModelAndView mav = new ModelAndView("MedicinesList");
		mav.addObject("empList", medicineService.getAllMedicineDetails());
		return mav;
	}

	@PostMapping("/updateMedicine")
	public ModelAndView updateMedicine(@ModelAttribute("medicine") MedicineDetails doctor) {
		medicineService.updateMedicineDetails(doctor);

		ModelAndView mav = new ModelAndView("MedicinesList");
		mav.addObject("empList", medicineService.getAllMedicineDetails());
		return mav;
	}

	@GetMapping("/getMedicineByID/{id}")
	public ModelAndView getMedicineByID(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("MedicinesList");
		MedicineDetails medicinerDetailsByID = medicineService.getMedicineDetailsByID(id);
		mav.addObject("medicine", medicinerDetailsByID);
		mav.setViewName("UpdateMedicine");
		return mav;
	}

	@GetMapping("/DeleteMedicinePage")
	public ModelAndView DeleteMedicinePage() {
		ModelAndView mav = new ModelAndView("DeleteMedicinesPage");
		mav.addObject("empList", medicineService.getAllMedicineDetails());
		return mav;
	}

	@GetMapping("/deleteMedicine/{id}")
	public ModelAndView deleteMedicine(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("MedicineList");
		String message = medicineService.deleteMedicineDetailsByID(id);

		if (message.equalsIgnoreCase("Not found"))
			mav.setViewName("FailureMessage");
		else if (message.equalsIgnoreCase("deleted"))
			mav.setViewName("MedicinesList");
//				mav.addObject("empList", appointmentServices.getAllAppointmentDetails());
		return mav;
	}

	//----------------patient medicine --------------------
	@GetMapping("/dd")
	public ModelAndView getmm(ModelMap mp) {
		ModelAndView mav = new ModelAndView("Navbar");
//		MedicineMapper obj = new MedicineMapper();
//		List<MedcineInfo> medicineInfo = new LinkedList<MedcineInfo>();
//		medicineInfo.addAll(Arrays.asList(
//
//				new MedcineInfo(1, "Med1", 0, "date1"), new MedcineInfo(2, "Med2", 0, "date2"),
//				new MedcineInfo(3, "Med3", 0, "date3"), new MedcineInfo(4, "Med4", 0, "date4"),
//				new MedcineInfo(5, "Med5", 0, "date5")));
////		obj.setMedicines(new MyInfo("Ankur", "Morshi"));
//		obj.setDoctorName("KEDAR");
//
//		mav.addObject("MedicineMapper", obj);
////		mav.addObject("list", obj.getMedicines());
////		mm.addAttribute("patientsList", patientServices.getAllPatientDetails().stream().map(dd -> dd.getPatientName())
////				.collect(Collectors.toList()));
//		mav.addObject("empList", Arrays.asList("NAna", "Kaka", "Mama"));
//		mp.addAttribute("empList", Arrays.asList("NAna", "Kaka", "Mama"));

		return mav;
	}

	


}