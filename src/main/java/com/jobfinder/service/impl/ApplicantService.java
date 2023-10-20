package com.jobfinder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobfinder.converter.ApplicantConverter;
import com.jobfinder.converter.UserConverter;
import com.jobfinder.dto.ApplicantDTO;
import com.jobfinder.dto.UserDTO;
import com.jobfinder.entity.ApplicantEntity;
import com.jobfinder.entity.RoleEntity;
import com.jobfinder.entity.UserEntity;
import com.jobfinder.repository.ApplicantRepository;
import com.jobfinder.repository.RoleRepository;
import com.jobfinder.repository.UserRepository;
import com.jobfinder.service.IApplicantService;

@Service
public class ApplicantService implements IApplicantService{
	
	@Autowired
	private ApplicantRepository applicantRepository;

	@Autowired
	private ApplicantConverter applicantConverter;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<ApplicantDTO> findAll() {
		List<ApplicantDTO> models = new ArrayList<>();
		List<ApplicantEntity> entities = applicantRepository.findAll();
		for (ApplicantEntity item : entities) {
			ApplicantDTO userModel = applicantConverter.toDto(item);
			models.add(userModel);
		}
		return models;
	}
	
	@Override
	public ApplicantDTO findById(long id) {
		ApplicantEntity entity = applicantRepository.findOne(id);
		return applicantConverter.toDto(entity);
	}
	
	@Override
	@Transactional
	public ApplicantDTO save(ApplicantDTO dto) {
		ApplicantEntity applicantEntity = new ApplicantEntity();
		UserEntity userEntity = new UserEntity();
		if (dto.getId() != null) {
			ApplicantEntity oldApplicant = applicantRepository.findOne(dto.getId());
			applicantEntity = applicantConverter.toEntity(oldApplicant, dto);
		} else {
			applicantEntity = applicantConverter.toEntity(dto);
			
			UserDTO userDTO = new UserDTO();
			userDTO.setUserName(dto.getUserName());
			userDTO.setPassword(dto.getPassword());
			userDTO.setFirstName(dto.getFirstName());
			userDTO.setLastName(dto.getLastName());
			userDTO.setEmail(dto.getEmail());
			
			userEntity = userConverter.toEntity(userDTO);
			
			List<RoleEntity> roles = new ArrayList<>();
			roles.add(roleRepository.findOne(dto.getRoleId()));
			userEntity.setRoles(roles);
			
			userEntity.setStatus(1);
			//save user
			userRepository.save(userEntity);
			
			applicantEntity.setUser(userEntity);
		}
		return applicantConverter.toDto(applicantRepository.save(applicantEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			applicantRepository.delete(id);
		}
	}
}
