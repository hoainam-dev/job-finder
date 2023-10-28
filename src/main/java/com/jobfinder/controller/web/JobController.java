package com.jobfinder.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobfinder.dto.CategoryDTO;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.service.ICategoryService;
import com.jobfinder.service.IJobService;

@Controller
@RequestMapping("/viec-lam")
public class JobController {
	
	@Value("${upload.dir}")
	private String uploadDir = System.getProperty("user.home") + "/Desktop/image";

	@Autowired
	private IJobService jobService;
	
	@Autowired
	private ICategoryService categoryService;
	

	@RequestMapping(value = "/danh-sach", method = RequestMethod.GET)
	public String jobsList(Model model) {
		List<JobDTO> jobs = jobService.findAll();
		List<CategoryDTO> categories = categoryService.findAll();
		model.addAttribute("jobs", jobs);
		model.addAttribute("categories", categories);
		return "web/list-job";
	}
	
	@RequestMapping(value = "/chi-tiet-bai-viet/{id}", method = RequestMethod.GET) 
	public String showJobDetail(@PathVariable("id") Long jobId, Model model) {
		JobDTO job = jobService.findById(jobId);
	    model.addAttribute("job", job);
	    return "web/job-detail";
	}
	
	@RequestMapping(value = "/tim-kiem" ,method = RequestMethod.GET)
    public String search(@RequestParam(name = "keyword", required = false) String keyword,
	            @RequestParam(name = "category", required = false) Long categoryId,
	            Model model) {
	List<JobDTO> jobs = jobService.search(keyword, categoryId);
	model.addAttribute("jobs", jobs);
	return "web/list-job";
	}
		
}