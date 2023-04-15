package com.bs.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.UserDetails;
import com.bs.repo.UserRepo;

@Service
public class AttributesCollector {

	@Autowired
	private UserRepo userRepo;

	public HttpServletRequest getAllAttribute(HttpServletRequest request, Integer userId) {
		List<UserDetails> findAll = userRepo.findAll();
		for (UserDetails details : findAll) {
			if (details.getUserID() == userId) {
				request.setAttribute("app_create_flag", details.getApp_create_flag());
				request.setAttribute("app_update_flag", details.getApp_update_flag());
				request.setAttribute("app_show_flag", details.getApp_show_flag());
				request.setAttribute("app_delete_flag", details.getApp_delete_flag());
				request.setAttribute("user_id", userId);
				break;
			}

		}
		return request;

	}
}
