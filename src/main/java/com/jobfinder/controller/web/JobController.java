package com.jobfinder.controller.web;
import java.security.Principal;
import java.util.List;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.jobfinder.service.IApplicantService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jobfinder.entity.ApplicantEntity;
import com.jobfinder.dto.ApplicantDTO;
import com.jobfinder.dto.CategoryDTO;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.service.ICategoryService;
import com.jobfinder.service.IJobService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/viec-lam")
public class JobController {
	private static final Logger logger = LoggerFactory.getLogger(JobController.class);
	@Value("${upload.dir}")
	private String uploadDir = System.getProperty("user.home") + "/Desktop/image";

	@Autowired
	private IJobService jobService;

	@Autowired
	private ICategoryService categoryService;
		
	
	
	@Autowired
	private IApplicantService applicantService;

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

	@RequestMapping(value = "/tim-kiem", method = RequestMethod.GET)
	public String search(@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "category", required = false) Long categoryId, Model model) {
		List<JobDTO> jobs = jobService.search(keyword, categoryId);
		model.addAttribute("jobs", jobs);
		return "web/list-job";
	}

	@RequestMapping(value = "/apply-form/{id}", method = RequestMethod.GET)
	public String showApplyForm(@PathVariable("id") Long jobId, Model model) {
		JobDTO job = jobService.findById(jobId);
		model.addAttribute("job", job);
		return "web/apply-form";
	}
	
	@RequestMapping(value = "/nop-ho-so-ung-tuyen/{jobId}", method = RequestMethod.POST)
	public String applyForJob(@PathVariable("jobId") Long jobId) {
	    try {
	        // Lấy thông tin Authentication
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	        // Kiểm tra xác thực không phải là ẩn danh
	        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
	            // Lấy tên người dùng từ đối tượng Authentication
	            String username = authentication.getName();

	            // Tìm kiếm thông tin ứng viên qua tên người dùng
	            ApplicantDTO applicant = applicantService.findByUsername(username);
	            JobDTO job = jobService.findById(jobId);
	            boolean isApplied = applicantService.applyForJob(applicant, job);
	            if (isApplied) {
	                return "redirect:/viec-lam/applied-jobs";
	            } else {
	                return "redirect:/viec-lam/chi-tiet-bai-viet/" + jobId;
	            }
	        } else {
	            return "redirect:/dang-nhap";
	        }
	    } catch (Exception e) {
	        return "redirect:/viec-lam/chi-tiet-bai-viet/" + jobId;
	    }
	}

	@RequestMapping(value = "/applied-jobs", method = RequestMethod.GET)
	public String showAppliedJobs(Model model) {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
	        String username = authentication.getName();
	        ApplicantDTO applicant = applicantService.findByUsername(username);

	        if (applicant != null) {
	            List<JobDTO> appliedJobs = applicantService.findAppliedJobs(applicant.getId());
	            model.addAttribute("appliedJobs", appliedJobs);

	            model.addAttribute("debugMessage", "Applicant found with ID: " + applicant.getId());
	        } else {
	            model.addAttribute("errorMessage", "Applicant information not found.");
	        }
	    } else {
	        model.addAttribute("errorMessage", "You must be logged in to view applied jobs.");
	    }
	    return "web/applied-jobs";
	}

}