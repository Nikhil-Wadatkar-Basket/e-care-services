package com.bs.webController;

import java.util.Arrays;
import java.util.List;

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
import com.bs.repo.UserRepo;
import com.bs.repo.VisitingDoctorRepo;

@Controller
public class UserController {

	@Autowired
	private UserRepo userRepo;
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

	@PostMapping("/logout")
	public String destroySession(HttpServletRequest request, Model model) {
		request.getSession().invalidate();
		return "redirect:/login";
	}

	@PostMapping("/authenticate")
	public ModelAndView authenticate(@ModelAttribute("userDetails") UserDetails userDetails,
			HttpServletRequest request) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//		userDetails.setRole("User");
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(userDetails);
		LoginResponse findByUserNameAndPassword = null;

		try {
			findByUserNameAndPassword = checkCredentials(userDetails);
		} catch (Exception e) {
			String message = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message);
		}

		// session code
//		String messages = (String) request.getSession().getAttribute("MY_ROLE");
//		if (messages == null) {
//			messages = "";
//			request.getSession().setAttribute("MY_ROLE", messages);
//			request.getSession().setAttribute("app_create_flag", "N");
//			request.getSession().setAttribute("app_show_flag", "N");
//			request.getSession().setAttribute("app_update_flag", "N");
//			request.getSession().setAttribute("app_delete_flag", "N");
//			request.getSession().setAttribute("access_code", "");
//			request.getSession().setAttribute("user_id", String.valueOf(findByUserNameAndPassword.getUserId()));
//			request.getSession().setAttribute("MY_ROLE", messages);
//		}
		// code to get session and update it in DB
//		manager.getSessionsByUserID(String.valueOf(findByUserNameAndPassword.getUserId()), request);

//		messages = findByUserNameAndPassword.getRole();

		if (true == findByUserNameAndPassword.isFlag())
			modelAndView.setViewName("Dashboard");
		else
			modelAndView.setViewName("ErrorLoginPage");

		return modelAndView;
	}

	private LoginResponse checkCredentials(UserDetails userDetails) {
		boolean flag = false;
		LoginResponse existedDetails = new LoginResponse();
		List<UserDetails> findAll = userRepo.findAll();

		for (UserDetails details : findAll) {
			if (details.getPassword().equals(userDetails.getPassword())
					&& details.getUserName().equals(userDetails.getUserName())
					&& details.getStatus().equalsIgnoreCase("Active")) {
				flag = true;
				existedDetails.setFlag(true);
				existedDetails.setUserId(details.getUserID());
				existedDetails.setUserName(details.getUserName());
				existedDetails.setRole(details.getRole());
				existedDetails.setPassword(details.getPassword());
				break;
			}
		}

		return existedDetails;
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
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		UserDetails details = new UserDetails();
		details.setCity(userDetails.getCity());
		details.setEmail(userDetails.getEmail());
		details.setName(userDetails.getName());
		details.setPassword(userDetails.getPassword());
		details.setRole(userDetails.getRole());
		details.setStatus(userDetails.getStatus());
		details.setUserName(userDetails.getUserName());
		details.setApp_create_flag("N");
		details.setApp_update_flag("N");
		details.setApp_delete_flag("N");
		details.setApp_show_flag("N");
		details.setAccessCode("#" + userDetails.getName() + userDetails.getRole());

		try {
			userRepo.save(details);
		} catch (Exception e) {
			String message = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message);
		}
		ModelAndView mav = new ModelAndView("UsersList");
		mav.addObject("empList", userRepo.findAll());
		return mav;
	}

	@PostMapping("/updateUser")
	public ModelAndView updateUser(@ModelAttribute("user") UserDetails userDetails, Object medicineService) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		try {
			userRepo.save(userDetails);
		} catch (Exception e) {
			String message = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message);
		}

		ModelAndView mav = new ModelAndView("UsersList");
		mav.addObject("empList", userRepo.findAll());
		return mav;
	}

	@GetMapping("/getUser/{id}")
	public ModelAndView getMedicineByID(@PathVariable("id") Integer id) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ModelAndView mav = new ModelAndView("UsersList");
		UserDetails medicinerDetailsByID = null;
		try {
			medicinerDetailsByID = userRepo.findById(id).get();
		} catch (Exception e) {
			String message = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message);
		}
		mav.addObject("user", medicinerDetailsByID);
		mav.addObject("rolesList", Arrays.asList("ADMIN", "USER"));
		mav.setViewName("UpdateUser");
		return mav;
	}

	@GetMapping("/deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable("id") Integer id) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		try {
			userRepo.deleteById(id);
		} catch (Exception e) {
			String message = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
					+ stackTrace[1].getLineNumber() + "_" + e.getMessage();
			throw new MyRuntimeException(message);
		}
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

		// code to get session and update it in DB
//		manager.getSessionsByUserID((String) request.getSession().getAttribute("user_id"), request);

//		Object user_id_attr = request.getSession().getAttribute("user_id");
////		attributesCollector.getAllAttribute(request, (Integer) user_id_attr);
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

}

class LoginResponse {
	private Integer userId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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
