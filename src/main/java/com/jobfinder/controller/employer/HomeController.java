package com.jobfinder.controller.employer;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jobfinder.dto.CategoryDTO;
import com.jobfinder.dto.EmployerDTO;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.dto.PositionDTO;
import com.jobfinder.dto.UserDTO;
import com.jobfinder.service.ICategoryService;
import com.jobfinder.service.IEmployerService;
import com.jobfinder.service.IJobService;
import com.jobfinder.service.IPositionService;
import com.jobfinder.service.ISkillService;
import com.jobfinder.service.IUserService;
import com.jobfinder.util.SecurityUtils;
import com.jobfinder.validation.JobValidation;

@Controller(value = "homeControllerOfEmployer")
@RequestMapping("/nha-tuyen-dung")
public class HomeController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IJobService jobService;
	
	@Autowired
	private IEmployerService employerService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IPositionService positionService;
	
	@Autowired
	private ISkillService skillService;
	
	@Autowired
	private JobValidation jobValidation;
	

	SecurityUtils user = new SecurityUtils();
	
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
		List<CategoryDTO> categories = categoryService.findAll();
		List<JobDTO> jobs = jobService.findAll();
		ModelAndView mav = new ModelAndView("employer/jobs");
		EmployerDTO employer = null;
		for(EmployerDTO empl: employerService.findAll()) {
			if(Long.parseLong(user.getPrincipal().getId()) == empl.getUser_id()) {
				employer = empl;
			}
		}
		mav.addObject("categories", categories);
		mav.addObject("employer", employer);
		mav.addObject("users", users);
		mav.addObject("jobs", jobs);
		return mav;
	}
	
	@RequestMapping(value = "/tao-viec-lam", method = RequestMethod.GET)
	public String createJob(Model model) {
		List<String> types = new ArrayList<String>();
		types.add("Full time");
		types.add("Part time");
		types.add("Remote");
		types.add("Freelance");
		
		List<CategoryDTO> categories = categoryService.findAll();
		List<PositionDTO> positions = positionService.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("positions", positions);
		model.addAttribute("types", types);
		EmployerDTO employer = null;
		for(EmployerDTO empl: employerService.findAll()) {
			if(Long.parseLong(user.getPrincipal().getId()) == empl.getUser_id()) {
				employer = empl;
			}
		}
		model.addAttribute("skills", skillService.findAll());
		model.addAttribute("employer", employer);
		model.addAttribute("jobDTO", new JobDTO());
		return "employer/create-job";
	}
	
	@RequestMapping(value = "/tao-viec-lam", method = RequestMethod.POST)
	public String createJob(@Valid JobDTO jobDTO, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		jobValidation.validate(jobDTO, bindingResult);//validation cho form dang ky nguoi tim viec
		EmployerDTO employer = null;
		for(EmployerDTO empl: employerService.findAll()) {
			if(Long.parseLong(user.getPrincipal().getId()) == empl.getUser_id()) {
				employer = empl;
			}
		}
		List<String> types = new ArrayList<String>();
		types.add("Full time");
		types.add("Part time");
		types.add("Remote");
		types.add("Freelance");
		if (bindingResult.hasErrors()) {
			//neu co loi return ve lai form va hien thi loi
			model.addAttribute("categories", categoryService.findAll());
			model.addAttribute("employer", employer);
			model.addAttribute("positions", positionService.findAll());
			model.addAttribute("skills", skillService.findAll());
			model.addAttribute("types", types);
			return "employer/create-job";
		}
		jobService.save(jobDTO);
		redirectAttributes.addFlashAttribute("message", "Register successfully");//truyen message thanh cong toi trang dang nhap
		redirectAttributes.addFlashAttribute("alert", "success");//truyen type message toi trang dang nhap
		return "redirect:/nha-tuyen-dung/viec-lam";
	}
}
