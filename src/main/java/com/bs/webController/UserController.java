package com.bs.webController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beans.FeedbackDetails;
import com.bs.beans.UserDetails;
import com.bs.exception.MyRuntimeException;
import com.bs.helper.AttributesCollector;
import com.bs.helper.SessionManager;
import com.bs.repo.FeedbackRepo;
import com.bs.repo.MedicinePatientRepo;
import com.bs.repo.MedicineRepo;
import com.bs.repo.UserDetailsRepo;
import com.bs.repo.UserRepo;
import com.bs.repo.VisitingDoctorRepo;

@Controller
public class UserController {

	@Autowired
	private UserDetailsRepo userDetailsRepo;
	@Autowired
	private MedicineRepo medicineRepo;
	@Autowired
	private FeedbackRepo feedbackRepo;
	@Autowired
	private AttributesCollector attributesCollector;
	@Autowired
	private MedicinePatientRepo medicinePatientRepo;
	@Autowired
	private VisitingDoctorRepo visitingDoctorRepo;
	@Autowired
	private SessionManager manager;

	@GetMapping("/login")
	public ModelAndView login(UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("LoginPage");
		modelAndView.addObject("userDetails", new UserDetails());
		return modelAndView;
	}

	@GetMapping("/logout")
	public String destroySession() {
//		request.getSession().invalidate();
		return "redirect:/login";
	}

//--------------------------------------------------------------

	@GetMapping("/Dashboard")
	public ModelAndView dashboard() {
		ModelAndView modelAndView = new ModelAndView("Dashboard");
		return modelAndView;
	}

	@GetMapping("/aboutUs")
	public ModelAndView aboutUs() {
		ModelAndView modelAndView = new ModelAndView("AboutUs");
		return modelAndView;
	}

	@GetMapping("/contactUs")
	public ModelAndView contactUs() {
		ModelAndView modelAndView = new ModelAndView("ContactUs");
		return modelAndView;
	}

	@GetMapping("/AppointmentDashboard")
	public ModelAndView AppointmentDashboard(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("AppointmentDashboard");
		String userID = (String) request.getSession().getAttribute("user_id");
		setAppointmentAttributes(modelAndView, userID);
		return modelAndView;
	}

	@GetMapping("/DoctorDashboard")
	public ModelAndView DoctorDashboard(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("DoctorDashboard");
		String userID = (String) request.getSession().getAttribute("user_id");
		setDoctorAttributes(modelAndView, userID);
		return modelAndView;
	}

	@GetMapping("/PatientDashboard")
	public ModelAndView PatientDashboard(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("PatientDashboard");
		String userID = (String) request.getSession().getAttribute("user_id");
		setPatientAttributes(modelAndView, userID);
		return modelAndView;
	}

	@GetMapping("/VisitorsDoctorDashboard")
	public ModelAndView VisitorsDoctorDashboard(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("VisitorsDoctorDashboard");
		String userID = (String) request.getSession().getAttribute("user_id");
		setVDoctorAttributes(modelAndView, userID);
		return modelAndView;
	}

	@GetMapping("/MedicineDashboard")
	public ModelAndView MedicineDashboard(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("MedicineDashboard");
		String userID = (String) request.getSession().getAttribute("user_id");
		setMedientAttributes(modelAndView, userID);
		return modelAndView;
	}

	@GetMapping("/PharmacyDashboard")
	public ModelAndView PharmacyDashboard(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("MedicinesList2");
		String userID = (String) request.getSession().getAttribute("user_id");
		setMedientAttributes(modelAndView, userID);
		return modelAndView;
	}

	@GetMapping("/MedicineCounterDashboard")
	public ModelAndView MedicineCounterDashboard(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("MedicineCounterDashboard");
		String userID = (String) request.getSession().getAttribute("user_id");
		setPharmaAttributes(modelAndView, userID);
		return modelAndView;
	}

	@GetMapping("/MedicinePatientsList")
	public ModelAndView MedicinePatientsList(HttpServletRequest request) {
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
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		try {
			feedbackRepo.save(details);
		} catch (Exception e) {
			String message = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message);
		}
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

	private void setDoctorAttributes(ModelAndView modelAndView, String userID) {
		UserDetails findById = userDetailsRepo.findById(userID).get();
		modelAndView.addObject("doc_create_flag", findById.getDoc_create_flag());
		modelAndView.addObject("doc_show_flag", findById.getDoc_show_flag());
		modelAndView.addObject("doc_delete_flag", findById.getDoc_delete_flag());
		modelAndView.addObject("doc_update_flag", findById.getDoc_update_flag());
	}

	// setAttributes code
	private void setAppointmentAttributes(ModelAndView modelAndView, String userID) {
		UserDetails findById = userDetailsRepo.findById(userID).get();
		modelAndView.addObject("app_create_flag", findById.getApp_create_flag());
		modelAndView.addObject("app_show_flag", findById.getApp_show_flag());
		modelAndView.addObject("app_delete_flag", findById.getApp_delete_flag());
		modelAndView.addObject("app_update_flag", findById.getApp_update_flag());
	}

	private void setPatientAttributes(ModelAndView modelAndView, String userID) {
		UserDetails findById = userDetailsRepo.findById(userID).get();
		modelAndView.addObject("pat_create_flag", findById.getPat_create_flag());
		modelAndView.addObject("pat_show_flag", findById.getPat_show_flag());
		modelAndView.addObject("pat_delete_flag", findById.getPat_delete_flag());
		modelAndView.addObject("pat_update_flag", findById.getPat_update_flag());
	}

	private void setVDoctorAttributes(ModelAndView modelAndView, String userID) {
		UserDetails findById = userDetailsRepo.findById(userID).get();
		modelAndView.addObject("vDoc_create_flag", findById.getvDoc_create_flag());
		modelAndView.addObject("vDoc_show_flag", findById.getvDoc_show_flag());
		modelAndView.addObject("vDoc_delete_flag", findById.getvDoc_delete_flag());
		modelAndView.addObject("vDoc_update_flag", findById.getvDoc_update_flag());
	}

	private void setICUAttributes(ModelAndView modelAndView, String userID) {
		UserDetails findById = userDetailsRepo.findById(userID).get();
		modelAndView.addObject("icu_create_flag", findById.getIcu_create_flag());
		modelAndView.addObject("icu_show_flag", findById.getIcu_show_flag());
		modelAndView.addObject("icu_delete_flag", findById.getIcu_delete_flag());
		modelAndView.addObject("icu_update_flag", findById.getIcu_update_flag());
	}

	private void setMedientAttributes(ModelAndView modelAndView, String userID) {
		UserDetails findById = userDetailsRepo.findById(userID).get();
		modelAndView.addObject("med_create_flag", findById.getMed_create_flag());
		modelAndView.addObject("med_show_flag", findById.getMed_show_flag());
		modelAndView.addObject("med_delete_flag", findById.getMed_delete_flag());
		modelAndView.addObject("med_update_flag", findById.getMed_update_flag());
	}
	private void setPharmaAttributes(ModelAndView modelAndView, String userID) {
		UserDetails findById = userDetailsRepo.findById(userID).get();
		modelAndView.addObject("pharm_create_flag", findById.getPharm_create_flag());
		modelAndView.addObject("pharm_show_flag", findById.getPharm_show_flag());
		modelAndView.addObject("pharm_delete_flag", findById.getPharm_delete_flag());
		modelAndView.addObject("pharm_update_flag", findById.getPharm_update_flag());
	}

}

class LoginResponse {
	private String userId;
	private String userName;
	private String role;
	private String password;
	private boolean flag;

	public LoginResponse() {
		super();
		this.userName = userName;
		this.role = role;
		this.password = password;
		this.flag = flag;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "LoginResponse [userId=" + userId + ", userName=" + userName + ", role=" + role + ", password="
				+ password + ", flag=" + flag + "]";
	}

}
