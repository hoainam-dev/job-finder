package com.jobfinder.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jobfinder.dto.UserDTO;
import com.jobfinder.entity.CategoryEntity;
import com.jobfinder.entity.JobEntity;
import com.jobfinder.service.IUserService;
import com.jobfinder.service.impl.CategoryService;
import com.jobfinder.service.impl.JobService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		List<JobEntity> jobs = jobService.getAllJobs();
		List<CategoryEntity> categories = categoryService.getAllCategories();
		List<UserDTO> users = userService.findAll();
		
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("jobs", jobs);
		mav.addObject("categories", categories);
		mav.addObject("users", users);
		
		return mav;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchByTitle(@RequestParam("keyword") String keyword, Model model) {
		List<JobEntity> jobs = jobService.findByTitle(keyword);
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("jobs", jobs);
		model.addAttribute("categories", categories);
		return "web/home";
	}
	
}
