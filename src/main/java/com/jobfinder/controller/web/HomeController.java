package com.jobfinder.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobfinder.dto.CategoryDTO;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.service.ICategoryService;
import com.jobfinder.service.IEmployerService;
import com.jobfinder.service.IJobService;
import com.jobfinder.service.IUserService;
import com.jobfinder.util.LocationUtil;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	
	@Autowired
	private IJobService jobService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IEmployerService employerService;
	
	LocationUtil locationUtil = new LocationUtil();

	/**
	 * method get mapping return home page
	 * @author namHH
	 * 
	 * @return view jsp
	 */
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		List<JobDTO> listJob = jobService.findAll();//get all job
		List<JobDTO> jobs = new ArrayList<>();
		
		List<CategoryDTO> ListCategory = categoryService.findAll();//get all category
		List<CategoryDTO> categories = new ArrayList<>();
		
		if(listJob.size()>4) {//get 4 job from list job
			for(int i=0 ; i<4 ; i++) {
				jobs.add(listJob.get(i));
			}
		}else {			
			jobs=listJob;
		}
		
		if(ListCategory.size()>4) {//get 4 category from list category
			for(int i=0 ; i<4 ; i++) {
				categories.add(ListCategory.get(i));
			}
		}else {			
			categories=ListCategory;
		}
		
		for(JobDTO job : jobs) {
			// set location from codename to name(thanh_pho_ha_noi -> Thanh Pho Ha Noi)
			job.setLocation(locationUtil.getLocation().get(job.getLocation()));
		}
		ModelAndView mav = new ModelAndView("web/home");//create model view jsp
		mav.addObject("jobs", jobs);// push jobs to view
		mav.addObject("categories", categories);// push categories to view
		mav.addObject("users", userService.findAll());// push users to view
		mav.addObject("employers", employerService.findAll());// push employers to view
		return mav;
	}
}
