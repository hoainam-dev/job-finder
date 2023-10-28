package com.jobfinder.converter;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.JobEntity;

@Component
public class JobConverter {
	
	public JobDTO toDto(JobEntity entity) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
		JobDTO result = new JobDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setDescription(entity.getDescription());
		result.setRequirements(entity.getRequirements());
		result.setSalary(entity.getSalary());
		result.setLocation(entity.getLocation());
		result.setPosition(entity.getPosition());
		if (entity.getCategory() != null) {
			result.setCategory_id(entity.getCategory().getId());
		}
		if (entity.getEmployer() != null) {
			result.setCategory_id(entity.getEmployer().getId());
		}
		result.setCreateAt(formatter.format(entity.getCreate_at().getTime()));
		result.setUpdateAt(formatter.format(entity.getUpdate_at().getTime()));
		return result; 
	}
	
	public JobEntity toEntity(JobDTO dto) {
		JobEntity result = new JobEntity();
		result.setTitle(dto.getTitle());
		result.setDescription(dto.getDescription());
		result.setRequirements(dto.getRequirements());
		result.setSalary(dto.getSalary());
		result.setLocation(dto.getLocation());
		result.setPosition(dto.getPosition());
		return result;
	}
	
	public JobEntity toEntity(JobEntity result, JobDTO dto) {
		result.setTitle(dto.getTitle());
		result.setDescription(dto.getDescription());
		result.setRequirements(dto.getRequirements());
		result.setSalary(dto.getSalary());
		result.setLocation(dto.getLocation());
		result.setPosition(dto.getPosition());
		return result;
	}

}