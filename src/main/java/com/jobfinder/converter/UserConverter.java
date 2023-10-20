package com.jobfinder.converter;

import org.springframework.stereotype.Component;

import com.jobfinder.dto.UserDTO;
import com.jobfinder.entity.UserEntity;
import com.jobfinder.security.BcryptPassword;

@Component
public class UserConverter {
	
	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setUserName(entity.getUserName());
		result.setPassword(entity.getPassword());
		result.setFirstName(entity.getFirstName());
		result.setLastName(entity.getLastName());
		result.setEmail(entity.getEmail());
		result.setAddress(entity.getAddress());
		result.setPhone(entity.getPhone());
		return result;
	}
	
	public UserEntity toEntity(UserDTO dto) {
		BcryptPassword bcryptPassword = new BcryptPassword();
		UserEntity result = new UserEntity();
		result.setUserName(dto.getUserName());
		result.setPassword(bcryptPassword.BcryptPass(dto.getPassword()));
		result.setFirstName(dto.getFirstName());
		result.setLastName(dto.getLastName());
		result.setEmail(dto.getEmail());
		result.setAddress(dto.getAddress());
		result.setPhone(dto.getPhone());
		return result;
	}
	
	public UserEntity toEntity(UserEntity result, UserDTO dto) {
		BcryptPassword bcryptPassword = new BcryptPassword();
		result.setUserName(dto.getUserName());
		result.setPassword(bcryptPassword.BcryptPass(dto.getPassword()));
		result.setFirstName(dto.getFirstName());
		result.setLastName(dto.getLastName());
		result.setEmail(dto.getEmail());
		result.setAddress(dto.getAddress());
		result.setPhone(dto.getPhone());
		return result;
	}
}
