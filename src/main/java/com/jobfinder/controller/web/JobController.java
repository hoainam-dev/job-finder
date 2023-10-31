package com.jobfinder.controller.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobfinder.dto.CategoryDTO;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.dto.PositionDTO;
import com.jobfinder.entity.CategoryEntity;
import com.jobfinder.entity.JobEntity;
import com.jobfinder.service.ICategoryService;
import com.jobfinder.service.IJobService;
import com.jobfinder.service.IPositionService;

@Controller
@RequestMapping("/viec-lam")
public class JobController {

	@Autowired
	private IJobService jobService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IPositionService positionService;
	
	@RequestMapping(value = "/danh-sach", method = RequestMethod.GET)
	public String jobsList(Model model) {
		List<JobDTO> jobs = jobService.findAll();
		List<CategoryDTO> categories = categoryService.findAll();
		model.addAttribute("jobs", jobs);
		model.addAttribute("categories", categories);
		return "web/list-test";
	}

	@RequestMapping(value = "/tim-kiem", method = RequestMethod.GET)
	public String jobsList(Model model, 
			@RequestParam(name = "category", required=false) String category,
			@RequestParam(name = "type", required=false) String type) {
		List<JobDTO> jobs = jobService.filter(category, type);
		List<CategoryDTO> categories = categoryService.findAll();
		List<PositionDTO> positions = positionService.findAll();
		model.addAttribute("jobs", jobs);
		model.addAttribute("categories", categories);
		model.addAttribute("positions", positions);
		return "web/list-test";
	}
	
	@RequestMapping(value = "/tao-viec-lam", method = RequestMethod.GET)
	public String showFormPostJob(Model model) {
		List<CategoryDTO> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("job", new JobDTO());
		return "web/post-form";
	}
	
	@RequestMapping(value = "/tao-viec-lam", method = RequestMethod.POST)
	public String createPostJob(@ModelAttribute("job") JobDTO dto, Model model) {
		if (dto.getTitle().isEmpty() || dto.getPosition().isEmpty() || dto.getDescription().isEmpty()
				|| dto.getLocation().isEmpty() || dto.getRequirements().isEmpty()) {
			model.addAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin");
			return "web/post-form";
		}
		jobService.save(dto);
		return "redirect:/viec-lam/danh-sach";
	}
	
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	public String getJobByCategory(@PathVariable Long categoryId, Model model) {
		List<CategoryDTO> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		List<JobDTO> jobs = jobService.findByCategoryId(categoryId);
		model.addAttribute("jobs", jobs);
		return"web/list-job";
	}
	
	@RequestMapping(value = "/chi-tiet-bai-viet/{id}", method = RequestMethod.GET) 
	public String showJobDetail(@PathVariable("id") Long jobId, Model model) {
		JobDTO job = jobService.findById(jobId);
	    model.addAttribute("job", job);
	    return "web/job-detail";
	}
	
//	@RequestMapping(value = "/tim-kiem" ,method = RequestMethod.GET)
//    public String search(@RequestParam(name = "keyword", required = false) String keyword,
//	            @RequestParam(name = "category", required = false) Long categoryId,
//	            Model model) {
//		List<CategoryDTO> categories = categoryService.findAll();
//		model.addAttribute("categories", categories);
//		List<JobDTO> jobs = jobService.search(keyword, categoryId);
//		model.addAttribute("jobs", jobs);
//		return "web/list-job";
//    }
	
	@RequestMapping(value = "/tim-kiem/tu-khoa", method = RequestMethod.GET)
	public String searchByTitle(@RequestParam("keyword") String keyword, Model model) {
		if (keyword.isEmpty()) {
			throw new IllegalArgumentException("Vui lòng điền từ khoá cần tìm");
		}
		List<JobDTO> jobs = jobService.findByTitle(keyword);
		List<CategoryDTO> categories = categoryService.findAll();
		model.addAttribute("jobs", jobs);
		model.addAttribute("categories", categories);
		return "web/list-job";
	}
	
	@RequestMapping(value = "/tim-kiem/dia-diem", method = RequestMethod.GET)
	public String searchByLocation(@RequestParam("location") String location, Model model) {
		List<JobDTO> jobs = jobService.findByLocation(location);
		List<CategoryDTO> categories = categoryService.findAll();
		model.addAttribute("jobs", jobs);
		model.addAttribute("categories", categories);
		return "web/list-job";
	}
	
	@RequestMapping(value = "/tim-kiem/vi-tri", method = RequestMethod.GET)
	public String searchByPosition(@RequestParam("position") String position, Model model) {
		if (position.isEmpty()) {
			throw new IllegalArgumentException("Vui lòng điền vị trí cần tìm");
		}
		List<JobDTO> jobs = jobService.findByPosition(position);
		List<CategoryDTO> categories = categoryService.findAll();
		model.addAttribute("jobs", jobs);
		model.addAttribute("categories", categories);
		return "web/list-job";
	}
	
	@RequestMapping(value = "/tim-kiem/luong", method = RequestMethod.GET)
	public String searchBySalary(@RequestParam("salary") String salaryStr,  Model model) {	
		if (salaryStr.isEmpty()) {
			throw new IllegalArgumentException("Vui lòng nhập mức lương");
		}
		List<JobDTO> jobs = jobService.findBySalary(salaryStr);
		List<CategoryDTO> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("jobs", jobs);
		return "web/list-job";
	}
	
	@RequestMapping(value = "/tim-kiem/categoryId", method = RequestMethod.GET)
	public String searchBycategoryId(@RequestParam("categoryId") Long categoryId, Model model) {
		List<JobDTO> jobs = jobService.findByCategoryId(categoryId);
		List<CategoryDTO> categories = categoryService.findAll();
		model.addAttribute("jobs", jobs);
		model.addAttribute("categories", categories);
		return "web/list-job";
	}
	
	
}