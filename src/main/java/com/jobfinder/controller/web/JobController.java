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
import com.jobfinder.util.LocationUtil;

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
	
	LocationUtil locationUtil = new LocationUtil();

	/**
	 * method get mapping to return list job
	 * @author nhannn
	 * 
	 * @param model
	 * @param categoryId
	 * @param type
	 * @param salary
	 * @param location
	 * @return view jsp
	 */
	@RequestMapping(value = "/danh-sach", method = RequestMethod.GET)
	public String jobsList(Model model, @RequestParam(name = "category", required=false) Long categoryId,
			@RequestParam(name = "type", required=false) String type,
			@RequestParam(name = "salary", required=false) Integer salary,
			@RequestParam(name = "location", required=false) String location) {
		List<JobDTO> jobs = jobService.findAll();//get all job
		
		if(categoryId!= null || type!=null || salary!=null || location!=null) {
			//filter job by categoryId, type, salary, location
			jobs = jobService.filter(categoryId, type, salary, location);
		}
		
		for(JobDTO job : jobs) {//set location
			job.setLocation(locationUtil.getLocation().get(job.getLocation()));
		}
		model.addAttribute("jobs", jobs);//push jobs to view
		model.addAttribute("categories", categoryService.findAll());//push categories to view
		model.addAttribute("employers", employerService.findAll());//push employers to view
		
		return "web/list-job";
	}

	/**
	 * method get mapping to return detail job page
	 * @author nhannn
	 * 
	 * @param jobId
	 * @param model
	 * @return view jsp
	 */
	@RequestMapping(value = "/chi-tiet-viec-lam/{id}", method = RequestMethod.GET)
	public String showJobDetail(@PathVariable("id") Long jobId, Model model) {
		JobDTO job = jobService.findById(jobId);//get job by id
		
		job.setLocation(locationUtil.getLocation().get(job.getLocation()));//set location
		
		model.addAttribute("categories", categoryService.findAll());//push categories to view
		model.addAttribute("skills", skillService.findAll());//push skills to view
		model.addAttribute("users", userService.findAll());//push users to view
		model.addAttribute("job", job);//push job to view
		model.addAttribute("employers", employerService.findAll());//push employers to view
		return "web/job-detail";
	}
}