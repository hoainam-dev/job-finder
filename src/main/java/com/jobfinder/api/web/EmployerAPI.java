package com.jobfinder.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobfinder.dto.EmployerDTO;
import com.jobfinder.service.IEmployerService;

@RestController(value = "EmployerAPIOfWeb")
public class EmployerAPI {
	
	@Autowired
	private IEmployerService employerService;
	
	@PostMapping("/api/employer")
	public EmployerDTO createEmployer(@RequestBody EmployerDTO employerDTO) {
		return employerService.save(employerDTO);
	}
	
	@PutMapping("/api/employer")
	public EmployerDTO updateEmployer(@RequestBody EmployerDTO employerDTO) {
		return employerService.save(employerDTO);
	}
	
	@DeleteMapping("/api/employer")
	public void deleteEmployer(@RequestBody long[] id) {
		employerService.delete(id);
		System.out.println("delete successfully!");
	}
}
