package com.jobfinder.controller.admin;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobfinder.dto.ApplicantDTO;
import com.jobfinder.dto.EmployerDTO;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.dto.UserDTO;
import com.jobfinder.entity.JobEntity;
import com.jobfinder.service.IApplicantService;
import com.jobfinder.service.IEmployerService;
import com.jobfinder.service.IJobService;
import com.jobfinder.service.IUserService;
import com.jobfinder.service.impl.UserService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IJobService jobService ;
	
	@Autowired 
	private IEmployerService employerService ;
	
	@Autowired
	private IApplicantService applicantService;
	// get data  for dashboard 
	@RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
	public String homePage(Model model) {
		List<UserDTO> users = userService.findAll();
		int countUser = users.size();
		List<JobEntity> jobs = jobService.getAllJobs();
		int countJob = jobs.size();
		List<EmployerDTO> employer = employerService.findAll();
		int countEmployer = employer.size();
		// model view 
		model.addAttribute("users", users);
		model.addAttribute("countUser", countUser);
		model.addAttribute("jobs", jobs);
		model.addAttribute("countJob", countJob);
		model.addAttribute("employer", employer);
		model.addAttribute("countEmployer", countEmployer);
		return "admin/home";
	}
	@RequestMapping(value = "/quan-tri/nguoi-tim-viec", method = RequestMethod.GET)
	public String ManageUsers(Model model) {
		List<ApplicantDTO> applicant = applicantService.findAll();
		int countUser = applicant.size();
		model.addAttribute("users", applicant);
		model.addAttribute("countUser", countUser);
		return "admin/users_table";
	}
	@RequestMapping(value = "/quan-tri/nguoi-tim-viec/{id}", method = RequestMethod.GET)
	public String detailProfileApplicant(@PathVariable Long id, Model model) {
	    ApplicantDTO applicant = applicantService.findById(id);
	    model.addAttribute("applicant", applicant);
	    return "admin/detail_profile_applicant";
	}

	@RequestMapping(value = "/quan-tri/cong-ty", method = RequestMethod.GET)
	public String ManageCompanies(Model model) {
		List<EmployerDTO> employerDTOs = employerService.findAll();
		int countEmployer = employerDTOs.size();
		model.addAttribute("employers" , employerDTOs);
		model.addAttribute("countEmployer" , countEmployer);
		return "admin/employers_table"; 
	}
	

	
	
}
