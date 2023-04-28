package com.bs.webController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beans.ErrorInfo;
import com.bs.beans.UserDetails;
import com.bs.exception.MyRuntimeException;
import com.bs.repo.UserDetailsRepo;
import com.bs.repo.UserRepo;

@Controller
public class ProviderAdminController {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserDetailsRepo userDetailsRepo;

	private void setAttributes(ModelAndView modelAndView, String userID) {
		UserDetails findById = userDetailsRepo.findById(userID).get();
		// appointment flag
		modelAndView.addObject("app_create_flag", findById.getApp_create_flag());
		modelAndView.addObject("app_show_flag", findById.getApp_show_flag());
		modelAndView.addObject("app_delete_flag", findById.getApp_delete_flag());
		modelAndView.addObject("app_update_flag", findById.getApp_update_flag());
		// patient flag
		modelAndView.addObject("pat_create_flag", findById.getPat_create_flag());
		modelAndView.addObject("pat_show_flag", findById.getPat_show_flag());
		modelAndView.addObject("pat_delete_flag", findById.getPat_delete_flag());
		modelAndView.addObject("pat_update_flag", findById.getPat_update_flag());
		// doc flags
		modelAndView.addObject("doc_create_flag", findById.getDoc_create_flag());
		modelAndView.addObject("doc_show_flag", findById.getDoc_show_flag());
		modelAndView.addObject("doc_delete_flag", findById.getDoc_delete_flag());
		modelAndView.addObject("doc_update_flag", findById.getDoc_update_flag());
		// med flags
		modelAndView.addObject("med_create_flag", findById.getMed_create_flag());
		modelAndView.addObject("med_show_flag", findById.getMed_show_flag());
		modelAndView.addObject("med_delete_flag", findById.getMed_delete_flag());
		modelAndView.addObject("med_update_flag", findById.getMed_update_flag());
//		/vDocflag
		modelAndView.addObject("vDoc_create_flag", findById.getvDoc_create_flag());
		modelAndView.addObject("vDoc_show_flag", findById.getvDoc_show_flag());
		modelAndView.addObject("vDoc_delete_flag", findById.getvDoc_delete_flag());
		modelAndView.addObject("vDoc_update_flag", findById.getvDoc_update_flag());
		// icu
		modelAndView.addObject("icu_create_flag", findById.getIcu_create_flag());
		modelAndView.addObject("icu_show_flag", findById.getIcu_show_flag());
		modelAndView.addObject("icu_delete_flag", findById.getIcu_delete_flag());
		modelAndView.addObject("icu_update_flag", findById.getIcu_update_flag());
		// pharm
		modelAndView.addObject("pharm_create_flag", findById.getPharm_create_flag());
		modelAndView.addObject("pharm_show_flag", findById.getPharm_show_flag());
		modelAndView.addObject("pharm_delete_flag", findById.getPharm_delete_flag());
		modelAndView.addObject("pharm_update_flag", findById.getPharm_update_flag());
	}

	@GetMapping("/provider")
	public ModelAndView get(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("ProviderAdmin");
		String userID = (String) request.getSession().getAttribute("user_id");

		// take below value from DB
		setAttributes(modelAndView, userID);
		// get user info based on user id
		UserDetails userDetails = userDetailsRepo.findById(userID).get();
		request.getSession().setAttribute("name", userDetails.getName());
		request.getSession().setAttribute("email", userDetails.getEmail());
		request.getSession().setAttribute("userName", userDetails.getUserName());
		request.getSession().setAttribute("city", userDetails.getCity());
		request.getSession().setAttribute("role", userDetails.getRole());

		modelAndView.addObject("userIds",
				userDetailsRepo.findAll().stream().map(us -> us.getUserID()).collect(Collectors.toList()));

		return modelAndView;
	}

	@GetMapping("/getUserInfo/{id}")
	public @ResponseBody UserDetails getUserInfo(@PathVariable("id") String userId, HttpServletRequest request) {
		UserDetails userDetails = userDetailsRepo.findById(userId).get();
		request.getSession().setAttribute("name", userDetails.getName());
		request.getSession().setAttribute("email", userDetails.getEmail());
		request.getSession().setAttribute("userName", userDetails.getUserName());
		request.getSession().setAttribute("city", userDetails.getCity());
		request.getSession().setAttribute("role", userDetails.getRole());
		return userDetails;
	}

	@RequestMapping(path = "/saveStatus", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView saveStatus(@RequestParam Map<String, String> name, HttpServletRequest request) {
		System.out.println("WebController.saveStatus()");
		String userID = (String) request.getSession().getAttribute("user_id");
		UserDetails findById = userDetailsRepo.findById(userID).get();
		// appointment flags
		findById.setApp_create_flag(name.get("app_create_flag"));
		findById.setApp_delete_flag(name.get("app_delete_flag"));
		findById.setApp_show_flag(name.get("app_show_flag"));
		findById.setApp_update_flag(name.get("app_update_flag"));
		// patients flags
		findById.setPat_create_flag(name.get("pat_create_flag"));
		findById.setPat_delete_flag(name.get("pat_delete_flag"));
		findById.setPat_show_flag(name.get("pat_show_flag"));
		findById.setPat_update_flag(name.get("pat_update_flag"));
		// doc flags
		findById.setDoc_create_flag(name.get("doc_create_flag"));
		findById.setDoc_delete_flag(name.get("doc_delete_flag"));
		findById.setDoc_show_flag(name.get("doc_show_flag"));
		findById.setDoc_update_flag(name.get("doc_update_flag"));
		// medicine
		findById.setMed_create_flag(name.get("med_create_flag"));
		findById.setMed_delete_flag(name.get("med_delete_flag"));
		findById.setMed_show_flag(name.get("med_show_flag"));
		findById.setMed_update_flag(name.get("med_update_flag"));
		// vDoc
		findById.setvDoc_create_flag(name.get("vDoc_create_flag"));
		findById.setvDoc_delete_flag(name.get("vDoc_delete_flag"));
		findById.setvDoc_show_flag(name.get("vDoc_show_flag"));
		findById.setvDoc_update_flag(name.get("vDoc_update_flag"));
		// icu details
		findById.setIcu_create_flag(name.get("icu_create_flag"));
		findById.setIcu_delete_flag(name.get("icu_delete_flag"));
		findById.setIcu_show_flag(name.get("icu_show_flag"));
		findById.setIcu_update_flag(name.get("icu_update_flag"));
		// pharm details
		findById.setPharm_create_flag(name.get("pharm_create_flag"));
		findById.setPharm_delete_flag(name.get("pharm_delete_flag"));
		findById.setPharm_show_flag(name.get("pharm_show_flag"));
		findById.setPharm_update_flag(name.get("pharm_update_flag"));

		userDetailsRepo.save(findById);

		return new ModelAndView("Dashboard");
	}

//	@GetMapping("/demo")
//	public ModelAndView demo() {
//		int vad = 1;
//		ModelAndView modelAndView = new ModelAndView("LoginPage");
//		String className = this.getClass().getName();
//		System.out.println("className: " + className);
//		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//
//		modelAndView.addObject("userDetails", new UserDetails());
//		if (vad > 0) {
//			ErrorInfo errorInfo = new ErrorInfo();
//			errorInfo.setClassName(stackTrace[1].getClassName());
//			errorInfo.setMethodName(stackTrace[1].getMethodName());
//			errorInfo.setLineNUmber(stackTrace[1].getLineNumber());
//			errorInfo.setExceptionMessage("Exception meeage");
//			errorInfo.setFileName(stackTrace[1].getFileName());
//			String message = stackTrace[1].getClassName() + "_" + stackTrace[1].getMethodName() + "_"
//					+ stackTrace[1].getLineNumber() + "_" + "Exception";
//
//			throw new MyRuntimeException(message);
//		}
//		return modelAndView;
//	}

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
		request.getSession().setAttribute("user_id", String.valueOf(findByUserNameAndPassword.getUserId()));

		if (true == findByUserNameAndPassword.isFlag())
			modelAndView.setViewName("Dashboard");
		else
			modelAndView.setViewName("ErrorLoginPage");

		// set all attributes
		UserDetails findById = userDetailsRepo.findById(findByUserNameAndPassword.getUserId()).get();
		System.out.println(findById);

		setAttributes(modelAndView, findById.getUserID());
		return modelAndView;
	}

	private LoginResponse checkCredentials(UserDetails userDetails) {
		boolean flag = false;
		LoginResponse existedDetails = new LoginResponse();
		List<UserDetails> findAll = userDetailsRepo.findAll();

		for (UserDetails details : findAll) {
			if (details.getPassword().equals(userDetails.getPassword())
					&& details.getUserName().equals(userDetails.getUserName())
					&& details.getStatus().equalsIgnoreCase("Active")) {
				flag = true;
				existedDetails.setFlag(true);
				existedDetails.setUserId((details.getUserID()));
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
		mav.addObject("rolesList", Arrays.asList("ADMIN", "USER", "ACCOUNT ADMIN", "PHARMACYST", "DOCTOR"));
		return mav;
	}

	@PostMapping("/createUser")
	public ModelAndView createUser(@ModelAttribute("medicine") UserDetails userDetails) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		UserDetails details = new UserDetails();
		details.setUserID(userDetails.getUserName() + "_" + userDetails.getRole());
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

			userDetailsRepo.save(details);
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
			userDetails.setUserID(userDetails.getUserName() + "_" + userDetails.getRole());
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
	public ModelAndView getMedicineByID(@PathVariable("id") String id) {
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
	public ModelAndView deleteUser(@PathVariable("id") String id) {
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
}
