package com.jobfinder.controller.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jobfinder.entity.CategoryEntity;
import com.jobfinder.entity.JobEntity;
import com.jobfinder.service.impl.CategoryService;
//import com.jobfinder.service.impl.CategoryService;
import com.jobfinder.service.impl.JobService;

@Controller
@RequestMapping("/viec-lam")
public class JobController {
	
	@Value("${upload.dir}")
	private String uploadDir = System.getProperty("user.home") + "/Desktop/image";

	@Autowired
	private JobService jobService;
	
	@Autowired
	private CategoryService categoryService;
	

	@RequestMapping(value = "/danh-sach", method = RequestMethod.GET)
	public String jobsList(Model model) {
		List<JobEntity> jobs = jobService.getAllJobs();
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("jobs", jobs);
		model.addAttribute("categories", categories);
		return "web/list-job";
	}
	
	@RequestMapping(value = "/tao-viec-lam", method = RequestMethod.GET)
	public String formPostJob(Model model) {
		List<CategoryEntity> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		JobEntity jobs = new JobEntity();
		model.addAttribute("jobs", jobs);
		return "web/post-form";
	}
	
	@RequestMapping(value = "/chi-tiet-bai-viet/{id}", method = RequestMethod.GET) 
	public String showJobDetail(@PathVariable("id") Long jobId, Model model) {
	    JobEntity job = jobService.getJobById(jobId);
	    model.addAttribute("job", job);
	    return "web/job-detail";
	}
	
	@RequestMapping(value = "/tim-kiem" ,method = RequestMethod.GET)
    public String search(@RequestParam(name = "keyword", required = false) String keyword,
	            @RequestParam(name = "category", required = false) Long categoryId,
	            Model model) {
	List<JobEntity> jobs = jobService.search(keyword, categoryId);
	model.addAttribute("jobs", jobs);
	return "web/list-job";
	}
		
}