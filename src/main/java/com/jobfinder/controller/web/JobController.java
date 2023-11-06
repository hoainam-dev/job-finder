package com.jobfinder.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobfinder.dto.JobDTO;
import com.jobfinder.service.ICategoryService;
import com.jobfinder.service.IEmployerService;
import com.jobfinder.service.IJobService;
import com.jobfinder.service.ISkillService;
import com.jobfinder.service.IUserService;

@Controller
@RequestMapping("/viec-lam")
public class JobController {

	@Autowired
	private IJobService jobService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IEmployerService employerService;
	
	@Autowired
	private ISkillService skillService;

	@RequestMapping(value = "/danh-sach", method = RequestMethod.GET)
	public String jobsList(Model model, @RequestParam(name = "cat", required = false) Long categoryId,
			@RequestParam(name = "type", required = false) String type,
			@RequestParam(name = "salary", required = false) Integer salary,
			@RequestParam(name = "location", required = false) String location) {
		List<JobDTO> jobs = jobService.findAll();

		if (categoryId != null || type != null || location!=null) {
			jobService.filter(categoryId, type, salary, location);
		}
		model.addAttribute("jobs", jobs);
		return "web/list-job";
	}

	@RequestMapping(value = "/chi-tiet-viec-lam/{id}", method = RequestMethod.GET)
	public String showJobDetail(@PathVariable("id") Long jobId, Model model) {
		JobDTO job = jobService.findById(jobId);
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("skills", skillService.findAll());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("job", job);
		model.addAttribute("employers", employerService.findAll());
		return "web/job-detail";
	}
}