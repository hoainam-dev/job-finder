//package com.jobfinder.controller.web;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.jobfinder.dto.JobDTO;
//import com.jobfinder.entity.JobEntity;
//import com.jobfinder.repository.JobRepository;
////import com.jobfinder.service.impl.CategoryService;
//import com.jobfinder.service.impl.JobService;
//
//@Controller
//@RequestMapping("/jobs")
//public class JobController {
//
//	@Autowired
//	private JobService jobService;
//	
//	@Autowired JobRepository jobRepository;
//	
////	@Autowired
////	private CategoryService categoryService;
//
//	@GetMapping("/list")
//	public String  listJobs(Model model) {
//		List<JobDTO> theJobs = jobService.findAll();
//			model.addAttribute("jobs", theJobs);
//			return "list-job";
//		
//	}
//}
