package com.jobfinder.converter;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.jobfinder.dto.ApplicantDTO;
import com.jobfinder.entity.ApplicantEntity;

@Component
public class ApplicantConverter {
	public ApplicantDTO toDto(ApplicantEntity entity) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
		ApplicantDTO result = new ApplicantDTO();
		result.setId(entity.getId());
		result.setSkills(entity.getSkills());
		result.setExperience(entity.getExperience());
		result.setEducation(entity.getEducation());
		if (entity.getUser() != null) {
			result.setUser_id(entity.getUser().getId());
			result.setEmail(entity.getUser().getEmail());
			result.setPhone(entity.getUser().getPhone());
			result.setAddress(entity.getUser().getAddress());
			result.setUserName(entity.getUser().getUserName());
			result.setFirstName(entity.getUser().getFirstName());
			result.setLastName(entity.getUser().getLastName());
			result.setStatus(entity.getUser().getStatus());
		}
		result.setCreateAt(formatter.format(entity.getCreate_at().getTime()));
		result.setUpdateAt(formatter.format(entity.getUpdate_at().getTime()));
		return result;
	}
	
	public ApplicantEntity toEntity(ApplicantDTO dto) {
		ApplicantEntity result = new ApplicantEntity();
		result.setSkills(dto.getSkills());
		result.setExperience(dto.getExperience());
		result.setEducation(dto.getEducation());
		return result;
	}
	
	public ApplicantEntity toEntity(ApplicantEntity result, ApplicantDTO dto) {
		result.setSkills(dto.getSkills());
		result.setExperience(dto.getExperience());
		result.setEducation(dto.getEducation());
		return result;
	}
}
