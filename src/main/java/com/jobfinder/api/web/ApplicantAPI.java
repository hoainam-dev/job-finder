package com.jobfinder.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobfinder.dto.ApplicantDTO;
import com.jobfinder.service.IApplicantService;

@RestController(value = "ApplicantAPIOfWeb")
public class ApplicantAPI {
	
	@Autowired
	private IApplicantService applicantService;
	
	@PostMapping("/api/applicant")
	public ApplicantDTO createApplicant(@RequestBody ApplicantDTO applicantDTO) {
		return applicantService.save(applicantDTO);
	}
	
	@PutMapping("/api/applicant")
	public ApplicantDTO updateApplicant(@RequestBody ApplicantDTO applicantDTO) {
		return applicantService.save(applicantDTO);
	}
	
	@DeleteMapping("/api/applicant")
	public void deleteApplicant(@RequestBody long[] id) {
		applicantService.delete(id);
		System.out.println("delete successfully!");
	}
}
