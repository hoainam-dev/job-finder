package com.jobfinder.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobfinder.dto.JobDTO;
import com.jobfinder.service.ICategoryService;
import com.jobfinder.service.IEmployerService;
import com.jobfinder.service.IJobService;
import com.jobfinder.service.IUserService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	
	@Autowired
	private IJobService jobService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IEmployerService employerService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		List<JobDTO> listJob = jobService.findAll();
		List<JobDTO> jobs = new ArrayList<>();
		if(listJob.size()>4) {
			for(int i=0 ; i<4 ; i++) {
				jobs.add(listJob.get(i));
			}
		}else {			
			jobs=listJob;
		}
		
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("jobs", jobs);
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("users", userService.findAll());
		mav.addObject("employers", employerService.findAll());
		return mav;
	}
}
