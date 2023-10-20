package com.jobfinder.converter;

import org.springframework.stereotype.Component;

import com.jobfinder.dto.EmployerDTO;
import com.jobfinder.entity.EmployerEntity;

@Component
public class EmployerConverter {
	public EmployerDTO toDto(EmployerEntity entity) {
		EmployerDTO result = new EmployerDTO();
		result.setId(entity.getId());
		result.setCompanyName(entity.getCompanyName());
		result.setCompanyAddress(entity.getCompanyAddress());
		result.setPosition(entity.getPosition());
		if (entity.getUser() != null) {
			result.setUser_id(entity.getUser().getId());
		}
		return result;
	}
	
	public EmployerEntity toEntity(EmployerDTO dto) {
		EmployerEntity result = new EmployerEntity();
		result.setCompanyName(dto.getCompanyName());
		result.setCompanyAddress(dto.getCompanyAddress());
		result.setPosition(dto.getPosition());
		return result;
	}
	
	public EmployerEntity toEntity(EmployerEntity result, EmployerDTO dto) {
		result.setCompanyName(dto.getCompanyName());
		result.setCompanyAddress(dto.getCompanyAddress());
		result.setPosition(dto.getPosition());
		return result;
	}
}
