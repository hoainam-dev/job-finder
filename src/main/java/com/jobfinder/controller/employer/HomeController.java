package com.jobfinder.controller.employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobfinder.service.IUserService;

@Controller(value = "homeControllerOfEmployer")
public class HomeController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/nha-tuyen-dung", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("employer/home");
		return mav;
	}
}
