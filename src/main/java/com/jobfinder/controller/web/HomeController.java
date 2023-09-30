package com.jobfinder.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
//	public ModelAndView homePage(@RequestParam(name="paypat", required = false) String message,@RequestParam(name="subject", required = false) String subjectCode) {
		ModelAndView mav = new ModelAndView("web/home");
//		List<TeacherDTO> teachers = new ArrayList<>();
//		List<WebXuDTO> webXu = webXuService.findAll();
//		List<SubjectDTO> subjects = new ArrayList<>();
//		for (String item : subjectService.findAll().keySet()) {
//			subjects.add(subjectConverter.toDto(subjectRepository.findOneByCode(item)));
//		}
//		mav.addObject("webXu", webXu);
//		mav.addObject("evaluates", evaluateService.findAll());
//		mav.addObject("saveTeachers", teacherStudentService.findAll());
//		mav.addObject("subjects", subjects);
//		mav.addObject("teachers", teacherService.findAll());
//		mav.addObject("students", studentService.findAll());
//		mav.addObject("teacherForSubjects", teachers);
//		mav.addObject("message", message);
		return mav;
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
	public ModelAndView registerPage(@RequestParam(value = "role", required = false) String role) {
		ModelAndView mav = new ModelAndView("auth/register/register");
		if (role != null) {
			if(role.equals("nha-tuyen-dung")) {
				mav = new ModelAndView("auth/register/employer-register");
			}
			if(role.equals("nguoi-tim-viec")) {
				mav = new ModelAndView("auth/register/applicant-register");
			}
		}
		return mav;
	}
}
