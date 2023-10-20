package com.jobfinder.converter;

import org.springframework.stereotype.Component;

import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.JobEntity;

@Component
public class JobConverter {
	
	public JobDTO toDto(JobEntity entity) {
		JobDTO result = new JobDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setDescription(entity.getDescription());
		result.setRequirements(entity.getRequirements());
		result.setSalary(entity.getSalary());
		result.setLocation(entity.getLocation());
//		if (entity.getCompanyEntity() != null) {
//			result.setCompany_id(entity.getCompanyEntity().getId());
//		}
		return result; 
	}
	
	public JobEntity toEntity(JobEntity dto) {
		JobEntity result = new JobEntity();
		result.setTitle(dto.getTitle());
		result.setDescription(dto.getDescription());
		result.setRequirements(dto.getRequirements());
		result.setSalary(dto.getSalary());
		result.setLocation(dto.getLocation());
		return result;
	}
	
	public JobEntity toEntity(JobEntity result, JobEntity dto) {
		result.setTitle(dto.getTitle());
		result.setDescription(dto.getDescription());
		result.setRequirements(dto.getRequirements());
		result.setSalary(dto.getSalary());
		result.setLocation(dto.getLocation());
		return result;
	}

}