package com.jobfinder.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jobfinder.dto.ApplicantDTO;
import com.jobfinder.dto.EmployerDTO;
import com.jobfinder.service.IApplicantService;
import com.jobfinder.service.IEmployerService;
import com.jobfinder.validation.ApplicantValidation;
import com.jobfinder.validation.EmployerValidation;

@Controller
public class AuthController {
	
	@Autowired
	private ApplicantValidation applicantValidation;
	
	@Autowired
	private EmployerValidation employerValidation;

	@Autowired
	private IApplicantService applicantService;
	
	@Autowired
	private IEmployerService employerService;
	
	
	/**
	 * View login page
	 * 
	 * 10242023 NamHH
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
	 * 10242023 NamHH
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
	 * View register page
	 * 
	 * 10242023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public String registerPage(Model model) {
		return "auth/register/register";
	}

	@RequestMapping(value = "/dang-ky-nguoi-tim-viec", method = RequestMethod.GET)
	public String registerApplicant(Model model) {
		model.addAttribute("applicantDTO", new ApplicantDTO());
		return "auth/register/applicant-register";
	}

	@RequestMapping(value = "/dang-ky-nha-tuyen-dung", method = RequestMethod.GET)
	public String registerEmployer(Model model) {
		model.addAttribute("employerDTO", new EmployerDTO());
		return "auth/register/employer-register";
	}
	
	/**
	 * Method post applicant
	 * 
	 * 10242023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/dang-ky-nguoi-tim-viec", method = RequestMethod.POST)
	public String registerApplicant(@Valid ApplicantDTO applicantDTO, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		applicantValidation.validate(applicantDTO, bindingResult);//validation cho form đăng ký người tìm việc
		if (bindingResult.hasErrors()) {
			//nếu có lỗi thì return về lại form và hiển thị lỗi
			return "auth/register/applicant-register";
		}
		applicantService.save(applicantDTO);//lưu data vào database
		redirectAttributes.addFlashAttribute("message", "Register successfully");//truyển message thành công tới trang đăng nhập
		redirectAttributes.addFlashAttribute("alert", "success");//truyển type message tới trang đăng nhập
		return "redirect:/dang-nhap";
	}
	
	public ApplicantValidation getApplicantValidator() {
        return applicantValidation;
    }
 
    public void setApplicantValidator(ApplicantValidation applicantValidation) {
        this.applicantValidation = applicantValidation;
    }
    
    /**
	 * Method post employer
	 * 
	 * 10242023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/dang-ky-nha-tuyen-dung", method = RequestMethod.POST)
	public String registerEmployer(@Valid EmployerDTO employerDTO, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		employerValidation.validate(employerDTO, bindingResult);//validation cho form đăng ký nhà tuyển dụng
		if (bindingResult.hasErrors()) {
			//nếu có lỗi thì return về lại form và hiển thị lỗi
			return "auth/register/employer-register";
		}
		employerService.save(employerDTO);
		redirectAttributes.addFlashAttribute("message", "Register successfully");//truyển message thành công tới trang đăng nhập
		redirectAttributes.addFlashAttribute("alert", "success");//truyển type message tới trang đăng nhập
		return "redirect:/dang-nhap";
	}
	
	public EmployerValidation getEmployerValidation() {
        return employerValidation;
    }
 
    public void setEmployerValidation(EmployerValidation employerValidation) {
        this.employerValidation = employerValidation;
    }
    
    
    /**
	 * Method denied login
	 * 
	 * 10242023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
}
