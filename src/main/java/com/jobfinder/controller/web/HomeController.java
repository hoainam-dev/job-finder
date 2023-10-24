package com.jobfinder.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobfinder.dto.UserDTO;
import com.jobfinder.entity.JobEntity;
import com.jobfinder.service.IUserService;
import com.jobfinder.service.impl.JobService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		List<JobEntity> jobs = jobService.getAllJobs();
		List<UserDTO> users = userService.findAll();
		
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("jobs", jobs);
		mav.addObject("users", users);
		
		return mav;
	}
}
