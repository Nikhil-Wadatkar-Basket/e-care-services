package com.bs.helper;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.UserDetails;
import com.bs.repo.UserRepo;

@Service
public class SessionManager {

	@Autowired
	private UserRepo repo;
	
	public String getSessionsByUserID(String userID,HttpServletRequest request) {
		
		Optional<UserDetails> findById = repo.findById(Integer.valueOf(userID));
		if(findById.isPresent()) {
			UserDetails userDetails = findById.get();
			request.getSession().setAttribute("app_create_flag", userDetails.getApp_create_flag());
			request.getSession().setAttribute("app_show_flag", userDetails.getApp_show_flag());
			request.getSession().setAttribute("app_update_flag", userDetails.getApp_update_flag());
			request.getSession().setAttribute("app_delete_flag", userDetails.getApp_delete_flag());
			request.getSession().setAttribute("access_code", "");
			request.getSession().setAttribute("user_id", userDetails.getUserID());
		}
		
		
		
		
		return null;
	}

}
