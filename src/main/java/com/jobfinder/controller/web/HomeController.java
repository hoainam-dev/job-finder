package com.jobfinder.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jobfinder.dto.CategoryDTO;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.dto.UserDTO;
import com.jobfinder.service.ICategoryService;
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

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		List<JobDTO> jobs = jobService.findAll();
		List<CategoryDTO> categories = categoryService.findAll();
		List<UserDTO> users = userService.findAll();
		
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("jobs", jobs);
		mav.addObject("categories", categories);
		mav.addObject("users", users);
		
		return mav;
	}
	
	@RequestMapping(value = "/tim-kiem", method = RequestMethod.GET)
	public String searchByTitle(@RequestParam("keyword") String keyword, Model model) {
		List<JobDTO> jobs = jobService.findByTitle(keyword);
		List<CategoryDTO> categories = categoryService.findAll();
		model.addAttribute("jobs", jobs);
		model.addAttribute("categories", categories);
		return "web/home";
	}
	
}
