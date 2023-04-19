package com.bs.webController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beans.AppointmentDetails;
import com.bs.beans.DoctorDetails;
import com.bs.beans.ErrorInfo;
import com.bs.beans.MedicineDetails;
import com.bs.beans.PatientDetails;
import com.bs.beans.UserDetails;
import com.bs.beans.VisitingDoctorDetails;
import com.bs.exception.MyRuntimeException;
import com.bs.helper.AttributesCollector;
import com.bs.helper.HelperService;
import com.bs.repo.UserRepo;
import com.bs.repo.VisitingDoctorRepo;
import com.bs.service.AppointmentService;
import com.bs.service.DoctorService;
import com.bs.service.MedicineService;
import com.bs.service.PatientService;
import com.bs.service.VisitingDoctorService;

@Controller
public class WebController {
	@Autowired
	private AppointmentService appointmentServices;
	@Autowired
	private DoctorService docServices;
	@Autowired
	private VisitingDoctorService visitingDocServices;
	@Autowired
	private PatientService patientServices;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private MedicineService medicineService;
	@Autowired
	private HelperService helperService;
	@Autowired
	private VisitingDoctorRepo visitingDoctorRepo;

	@Autowired
	private AttributesCollector attributesCollector;

	@GetMapping("/demo")
	public ModelAndView demo() {
		int vad = 1;
		ModelAndView modelAndView = new ModelAndView("LoginPage");

		String className = this.getClass().getName();
		System.out.println("className: " + className);
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

		modelAndView.addObject("userDetails", new UserDetails());
		if (vad > 0) {

			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setClassName(stackTrace[1].getClassName());
			errorInfo.setMethodName(stackTrace[1].getMethodName());
			errorInfo.setLineNUmber(stackTrace[1].getLineNumber());
			errorInfo.setExceptionMessage("Exception meeage");
			errorInfo.setFileName(stackTrace[1].getFileName());
			String message = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + "Exception";

			throw new MyRuntimeException(message);
		}

		return modelAndView;
	}

	@GetMapping("/getAppointmentsList")
	public ModelAndView getAppointmentsList() {
		ModelAndView mav = new ModelAndView("AppointmentsList");
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		try {
			mav.addObject("empList", appointmentServices.getAllAppointmentDetails());
		} catch (Exception e) {
			String message = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message);
		}
		return mav;
	}

	@GetMapping("/getAppointmentByTime/{time}")
	public ModelAndView getAppointmentByID(@PathVariable("time") String id) {
		ModelAndView mav = new ModelAndView("AppointmentsList");
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		List<String> freeTimeSlots;
		try {
			AppointmentDetails appointmentDetailsByID = appointmentServices.getAppointmentDetailsByAppTime(id);
			mav.addObject("app", appointmentDetailsByID);
			mav.addObject("doctorList", getAvailableDoctors());
			freeTimeSlots = appointmentServices.getFreeTimesSlotes();
		} catch (Exception e) {
			String message = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message);
		}
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
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("AppointmentsList");
		String message = "";
		try {
			message = appointmentServices.deleteAppointmentDetailsByAppTime(id);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}

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
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		try {
			appointmentServices.updateAppointmentDetails(userDetails);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
		ModelAndView mav = new ModelAndView("AppointmentsList");
		mav.addObject("empList", appointmentServices.getAllAppointmentDetails());
		return mav;
	}

	@GetMapping("/loadNewAppointmentPage")
	public ModelAndView loadNewAppointmentPage() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("NewAppointmentImage");
		mav.addObject("app", new AppointmentDetails());

		mav.addObject("doctorList", getAvailableDoctors());
		List<String> freeTimeSlots = appointmentServices.getFreeTimesSlotes();
		mav.addObject("freeTimeSlots", freeTimeSlots);
		mav.addObject("bloodGroups", Arrays.asList("O +ve", "O -ve", "A +ve", "A -ve", "B -ve", "B +ve"));

		return mav;
	}

	@PostMapping("/createNewAppointment")
	public ModelAndView createNewAppointment(@ModelAttribute("app") AppointmentDetails userDetails) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		// call patient service to fill other patient details
		try {
			helperService.addPatientDetailsFromAppointment(userDetails);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
//		appointmentServices.createAppointmentDetails(userDetails);
		ModelAndView mav = new ModelAndView("AppointmentsList");
		mav.addObject("empList", appointmentServices.getAllAppointmentDetails());
		return mav;
	}

	@GetMapping("/DeleteAppointmentsPage")
	public ModelAndView deleteAppointmentsPage() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("DeleteAppointmentsPage");
		mav.addObject("empList", appointmentServices.getAllAppointmentDetails().stream()
				.filter(ss -> ss.getAppTimeStatue().equalsIgnoreCase("booked")).collect(Collectors.toList()));
		return mav;
	}

	// -----------------------doctor------------------------------------------------------
	@GetMapping("/showDoctors")
	public ModelAndView showDoctors() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("DoctorList");
		mav.addObject("empList", docServices.getAllDoctorDetails());
		return mav;
	}

	@GetMapping("/loadNewDoctorPage")
	public ModelAndView loadNewDoctorPage() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("NewDoctor");
		mav.addObject("doc", new DoctorDetails());
		mav.addObject("designationList", Arrays.asList("MD", "MBBS", "MS"));
		return mav;
	}

	@PostMapping("/createDoctor")
	public ModelAndView createDoctor(@ModelAttribute("doc") DoctorDetails doctor) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		try {
			docServices.createDoctorDetails(doctor);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
		ModelAndView mav = new ModelAndView("DoctorList");
		mav.addObject("empList", docServices.getAllDoctorDetails());
		return mav;
	}

	@PostMapping("/updateDoctor")
	public ModelAndView updateDoctor(@ModelAttribute("doc") DoctorDetails doctor) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		try {
			docServices.updateDoctorDetails(doctor);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}

		ModelAndView mav = new ModelAndView("DoctorList");
		mav.addObject("empList", docServices.getAllDoctorDetails());
		return mav;
	}

	@GetMapping("/getDoctor/{id}")
	public ModelAndView getDoctor(@PathVariable("id") Integer id) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("DoctorList");
		DoctorDetails doctorDetailsByID = null;
		try {
			doctorDetailsByID = docServices.getDoctorDetailsByID(id);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
		mav.addObject("doc", doctorDetailsByID);
		mav.setViewName("UpdateDoctor");
		return mav;
	}

	@GetMapping("/DeleteDoctorPage")
	public ModelAndView DeleteDoctorPage() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("DeleteDoctorPage");
		mav.addObject("empList", docServices.getAllDoctorDetails());
		return mav;
	}

	@GetMapping("/deleteDoctor/{id}")
	public ModelAndView deleteDoctor(@PathVariable("id") Integer id) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("DoctorList");
		String message = null;
		try {
			message = docServices.deleteDoctorDetailsByID(id);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
		mav.addObject("empList", docServices.getAllDoctorDetails());
		return mav;
	}

	@GetMapping("/getDoctorByID/{id}")
	public ModelAndView getDoctorByID(@PathVariable("id") Integer id) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("DoctorList");

		DoctorDetails appointmentDetailsByID = null;
		try {
			appointmentDetailsByID = docServices.getDoctorDetailsByID(id);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
		mav.addObject("app", appointmentDetailsByID);

		mav.setViewName("UpdateDoctor");
		return mav;
	}

	// ----------------------patient---------------------------
	@GetMapping("/showPatients")
	public ModelAndView showPatients() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("PatientsList");
		mav.addObject("empList", patientServices.getAllPatientDetails());
		return mav;
	}

	@GetMapping("/loadNewPatientPage")
	public ModelAndView loadNewPatientPage() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
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
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		PatientDetails patientID = null;
		try {
			patientID = patientServices.createPatientDetails(doctor);
			helperService.createAppointmentforPatient(patientID);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
		ModelAndView mav = new ModelAndView("PatientsList");
		mav.addObject("empList", patientServices.getAllPatientDetails());
		return mav;
	}

	@PostMapping("/updatePatient")
	public ModelAndView updatePatient(@ModelAttribute("patient") PatientDetails doctor) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		try {
			patientServices.updatePatientDetails(doctor);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}

		ModelAndView mav = new ModelAndView("PatientsList");
		mav.addObject("empList", patientServices.getAllPatientDetails());
		return mav;
	}

	@GetMapping("/getPatientByID/{id}")
	public ModelAndView getPatientByID(@PathVariable("id") Integer id) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("PatientsList");
		PatientDetails patientrDetailsByID = null;
		List<String> freeTimeSlots = null;

		try {
			patientrDetailsByID = patientServices.getPatientDetailsByID(id);
			freeTimeSlots = appointmentServices.getFreeTimesSlotes();
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}

		mav.addObject("patient", patientrDetailsByID);
		mav.addObject("doctorList", getAvailableDoctors());
		mav.addObject("freeTimeSlots", freeTimeSlots);
		mav.addObject("bloodGroups", Arrays.asList("O +ve", "O -ve", "A +ve", "A -ve", "B -ve", "B +ve"));
		mav.setViewName("UpdatePatient");
		return mav;
	}

	@GetMapping("/DeletePatientPage")
	public ModelAndView DeletePatientPage() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("DeletePatientsPage");
		mav.addObject("empList", patientServices.getAllPatientDetails());
		return mav;
	}

	@GetMapping("/deletePatient/{id}")
	public ModelAndView deletePatient(@PathVariable("id") Integer id) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("PatientsList");
		try {
			helperService.deletePatientsFromAppointment(id);
			patientServices.deletePatientDetailsByID(id);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
		mav.setViewName("PatientsList");
		mav.addObject("empList", patientServices.getAllPatientDetails());
		return mav;
	}
//------------medicine---------------------

	@GetMapping("/showMedicines")
	public ModelAndView showMedicines() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("MedicinesList");
		mav.addObject("empList", medicineService.getAllMedicineDetails());
		return mav;
	}

	@GetMapping("/loadNewMedicinePage")
	public ModelAndView loadNewMedicinePage() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("NewMedicine");
		mav.addObject("medicine", new MedicineDetails());
//				mav.addObject("designationList", Arrays.asList("MD", "MBBS", "MS"));
		return mav;
	}

	@PostMapping("/createMedicine")
	public ModelAndView createMedicine(@ModelAttribute("medicine") MedicineDetails doctor) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("MedicinesList");

		try {
			medicineService.createMedicineDetails(doctor);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
		mav.addObject("empList", medicineService.getAllMedicineDetails());
		return mav;
	}

	@PostMapping("/updateMedicine")
	public ModelAndView updateMedicine(@ModelAttribute("medicine") MedicineDetails doctor) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

		try {
			medicineService.updateMedicineDetails(doctor);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}

		ModelAndView mav = new ModelAndView("MedicinesList");
		mav.addObject("empList", medicineService.getAllMedicineDetails());
		return mav;
	}

	@GetMapping("/getMedicineByID/{id}")
	public ModelAndView getMedicineByID(@PathVariable("id") Integer id) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("MedicinesList");
		MedicineDetails medicinerDetailsByID = null;

		try {
			medicinerDetailsByID = medicineService.getMedicineDetailsByID(id);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}

		mav.addObject("medicine", medicinerDetailsByID);
		mav.setViewName("UpdateMedicine");
		return mav;
	}

	@GetMapping("/DeleteMedicinePage")
	public ModelAndView DeleteMedicinePage() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("DeleteMedicinesPage");
		mav.addObject("empList", medicineService.getAllMedicineDetails());
		return mav;
	}

	@GetMapping("/deleteMedicine/{id}")
	public ModelAndView deleteMedicine(@PathVariable("id") Integer id) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("MedicineList");
		String message = null;

		try {
			message = medicineService.deleteMedicineDetailsByID(id);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}

		mav.setViewName("MedicinesList");
		mav.addObject("empList", medicineService.getAllMedicineDetails());
		return mav;
	}

	// ----------------patient medicine --------------------
	@GetMapping("/dd")
	public ModelAndView getmm(ModelMap mp) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
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

//------------------visiting doctor page-----------------------------
	@GetMapping("/loadNewVisitingDoctorPage")
	public ModelAndView loadNewVisitingDoctorPage() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("NewVisitingDoctor");
		mav.addObject("doc", new VisitingDoctorDetails());
		mav.addObject("designationList", Arrays.asList("MD", "MBBS", "MS"));
		return mav;
	}

	@GetMapping("/visitngDoctorList")
	public ModelAndView visitngDoctorList() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView modelAndView = new ModelAndView("VisitingDoctorList");
		modelAndView.addObject("empList", visitingDoctorRepo.findAll());
		return modelAndView;
	}

	@PostMapping("/createVisitingDoctor")
	public ModelAndView createVisitingDoctor(@ModelAttribute("doc") VisitingDoctorDetails doctor) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		try {
			visitingDocServices.createVisitingDoctorDetails(doctor);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
		ModelAndView mav = new ModelAndView("VisitingDoctorList");
		mav.addObject("empList", visitingDoctorRepo.findAll());
		return mav;
	}

	@PostMapping("/updateVisitingDoctor")
	public ModelAndView updateVisitingDoctor(@ModelAttribute("doc") VisitingDoctorDetails doctor) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		try {
			visitingDocServices.updateVisitingDoctorDetails(doctor);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
		ModelAndView mav = new ModelAndView("VisitingDoctorList");
		mav.addObject("empList", visitingDoctorRepo.findAll());
		return mav;
	}

	@GetMapping("/getVisitingDoctor/{id}")
	public ModelAndView getVisitingDoctor(@PathVariable("id") Integer id) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("VisitingDoctorList");
		VisitingDoctorDetails doctorDetailsByID = null;

		try {
			doctorDetailsByID = visitingDocServices.getVisitingDoctorDetailsByID(id);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}
		mav.addObject("doc", doctorDetailsByID);
		mav.addObject("designationList", Arrays.asList("MD", "MBBS", "MS"));
		mav.setViewName("UpdateVisitingDoctor");
		return mav;
	}

	@GetMapping("/DeleteVisitingDoctorPage")
	public ModelAndView DeleteVisitingDoctorPage() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("DeleteDoctorPage");
		mav.addObject("empList", visitingDoctorRepo.findAll());
		return mav;
	}

	@GetMapping("/deleteVisitingDoctor/{id}")
	public ModelAndView deleteVisitingDoctor(@PathVariable("id") Integer id) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("VisitingDoctorList");
		String message = null;

		try {
			message = visitingDocServices.deleteVisitingDoctorDetailsByID(id);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}

		if (message.equalsIgnoreCase("Not found"))
			mav.setViewName("FailureMessage");
		else if (message.equalsIgnoreCase("deleted"))
			mav.setViewName("VisitingDoctorList");
		mav.addObject("empList", visitingDoctorRepo.findAll());
		return mav;
	}

	@GetMapping("/getVisitingDoctorByID/{id}")
	public ModelAndView getVisitingDoctorByID(@PathVariable("id") Integer id) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("DoctorList");

		VisitingDoctorDetails appointmentDetailsByID = null;
		try {
			appointmentDetailsByID = visitingDocServices.getVisitingDoctorDetailsByID(id);
		} catch (Exception e) {
			String message1 = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message1);
		}

		mav.addObject("app", appointmentDetailsByID);
		mav.setViewName("UpdateVisitingDoctor");
		return mav;
	}

}