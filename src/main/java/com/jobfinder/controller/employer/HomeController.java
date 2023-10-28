package com.jobfinder.controller.employer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobfinder.dto.JobDTO;
import com.jobfinder.dto.UserDTO;
import com.jobfinder.service.IJobService;
import com.jobfinder.service.IUserService;

@Controller(value = "homeControllerOfEmployer")
@RequestMapping("/nha-tuyen-dung")
public class HomeController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IJobService jobService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		List<UserDTO> users = userService.findAll();
		List<JobDTO> jobs = jobService.findAll();
		ModelAndView mav = new ModelAndView("employer/home");
		mav.addObject("users", users);
		mav.addObject("totalJob", jobs.size());
		return mav;
	}
	
	@RequestMapping(value = "/viec-lam", method = RequestMethod.GET)
	public ModelAndView jobPage() {
		List<UserDTO> users = userService.findAll();
		List<JobDTO> jobs = jobService.findAll();
		ModelAndView mav = new ModelAndView("employer/jobs");
		mav.addObject("users", users);
		mav.addObject("jobs", jobs);
		return mav;
	}
}
