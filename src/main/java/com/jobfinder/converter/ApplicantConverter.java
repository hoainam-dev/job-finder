package com.jobfinder.converter;

import org.springframework.stereotype.Component;

import com.jobfinder.dto.ApplicantDTO;
import com.jobfinder.entity.ApplicantEntity;

@Component
public class ApplicantConverter {
	public ApplicantDTO toDto(ApplicantEntity entity) {
		ApplicantDTO result = new ApplicantDTO();
		result.setId(entity.getId());
		result.setSkills(entity.getSkills());
		result.setExperience(entity.getExperience());
		result.setEducation(entity.getEducation());
		if (entity.getUser() != null) {
			result.setUser_id(entity.getUser().getId());
		}
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
