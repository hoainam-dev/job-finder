package com.jobfinder.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jobfinder.dto.CategoryDTO;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.dto.UserDTO;
import com.jobfinder.entity.CategoryEntity;
import com.jobfinder.entity.JobEntity;
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
	
	@RequestMapping(value = "/thong-tin-ca-nhan", method = RequestMethod.GET)
	public String showEditForm(@RequestParam(value = "id") Long id, Model model) {
		UserDTO user = userService.findById(id);
		model.addAttribute("user", user);
		return "web/user-profile";
	}

	@RequestMapping(value = "/thong-tin-ca-nhan", method = RequestMethod.POST)
	public String updateUser(@RequestParam(value = "id") Long userId, UserDTO userDTO
			, RedirectAttributes redirectAttributes) {
		userService.save(userDTO);
		redirectAttributes.addFlashAttribute("message", "Đổi thông tin thành công");//truyen message thanh cong toi trang dang nhap
		redirectAttributes.addFlashAttribute("alert", "success");//truyen type message toi trang dang nhap
		return "redirect:/thong-tin-ca-nhan?id=" + userId;
	}
	
	@RequestMapping(value = "/tim-kiem", method = RequestMethod.GET)
	public String searchByTitle(@RequestParam("keyword") String keyword, Model model) {
		List<JobDTO> jobs = jobService.findByTitle(keyword);
		model.addAttribute("jobs", jobs);
		return "web/home";
	}
}
