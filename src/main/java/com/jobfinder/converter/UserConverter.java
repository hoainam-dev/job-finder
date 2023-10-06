package com.jobfinder.converter;

import org.springframework.stereotype.Component;

import com.jobfinder.dto.UserDTO;
import com.jobfinder.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setUserName(entity.getUserName());
		result.setPassword(entity.getPassword());
		result.setEmail(entity.getEmail());
		result.setFirstName(entity.getFirstName());
		result.setLastName(entity.getLastName());
		result.setAddress(entity.getAddress());
		result.setPhone(entity.getPhone());
		if (entity.getApplicant() != null) {
			result.setApplicant_id(entity.getApplicant().getId());
		}
		if (entity.getEmployer() != null) {
			result.setEmployer_id(entity.getEmployer().getId());
		}
		return result;
	}
	
	public UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setUserName(dto.getUserName());
		result.setEmail(dto.getEmail());
		result.setFirstName(dto.getFirstName());
		result.setLastName(dto.getLastName());
		result.setAddress(dto.getAddress());
		result.setPhone(dto.getPhone());
		return result;
	}
	
	public UserEntity toEntity(UserEntity result, UserDTO dto) {
		result.setUserName(dto.getUserName());
		result.setPassword(dto.getPassword());
		result.setEmail(dto.getEmail());
		result.setFirstName(dto.getFirstName());
		result.setLastName(dto.getLastName());
		result.setAddress(dto.getAddress());
		result.setPhone(dto.getPhone());
		return result;
	}
}
