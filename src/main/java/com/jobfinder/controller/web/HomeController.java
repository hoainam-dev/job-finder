package com.jobfinder.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	/**
	 * View login page
	 * 
	 * 03152023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "message", required = false) String message) {
		ModelAndView mav = new ModelAndView("auth/login/login");
		if (message != null) {
			mav.addObject("message", message);
			mav.addObject("alert", "success");
		}
		return mav;
	}
	
	/**
	 * Method Logout
	 * 
	 * 03152023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
	/**
	 * View login page
	 * 
	 * 03152023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView registerPage(@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "message", required = false) String message){
		ModelAndView mav = new ModelAndView("auth/register/register");
		if (type != null) {
			if(type.equals("nha-tuyen-dung")) {
				mav = new ModelAndView("auth/register/employer-register");
				if (message != null) {
					mav.addObject("message", message);
					mav.addObject("alert", "success");
				}
			}
			if(type.equals("nguoi-tim-viec")) {
				mav = new ModelAndView("auth/register/applicant-register");
				if (message != null) {
					mav.addObject("message", message);
					mav.addObject("alert", "success");
				}
			}
		}
		return mav;
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
}
