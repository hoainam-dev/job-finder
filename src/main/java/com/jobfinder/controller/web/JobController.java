package com.jobfinder.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.JobEntity;
import com.jobfinder.repository.JobRepository;
//import com.jobfinder.service.impl.CategoryService;
import com.jobfinder.service.impl.JobService;

@Controller
@RequestMapping("/viec-lam")
public class JobController {

	@Autowired
	private JobService jobService;
	
	@Autowired JobRepository jobRepository;
	
//	@Autowired
//	private CategoryService categoryService

	@RequestMapping(value = "/danh-sach", method = RequestMethod.GET)
	public String jobsList(Model model) {
		List<JobEntity> jobs = jobService.getAllJobs();
		model.addAttribute("jobs", jobs);
		return "web/list-job";
	}
	
	@RequestMapping(value = "/tao-viec-lam", method = RequestMethod.GET)
	public String formPostJob(Model model) {
		JobEntity jobs = new JobEntity();
		model.addAttribute("jobs", jobs);
		return "web/post-form";
	}
	
	@RequestMapping(value = "/tao-viec-lam", method = RequestMethod.POST)
	public String createPost(@ModelAttribute("jobs") JobEntity jobEntity) {
		jobService.createPost(jobEntity);
		return "redirect:/jobs";
	}
}
