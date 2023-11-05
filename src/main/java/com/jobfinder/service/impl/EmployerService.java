package com.jobfinder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobfinder.converter.EmployerConverter;
import com.jobfinder.converter.UserConverter;
import com.jobfinder.dto.EmployerDTO;
import com.jobfinder.dto.UserDTO;
import com.jobfinder.entity.EmployerEntity;
import com.jobfinder.entity.RoleEntity;
import com.jobfinder.entity.UserEntity;
import com.jobfinder.repository.EmployerRepository;
import com.jobfinder.repository.RoleRepository;
import com.jobfinder.repository.UserRepository;
import com.jobfinder.service.IEmployerService;

@Service
public class EmployerService implements IEmployerService{
	
	@Autowired
	private EmployerRepository employerRepository;

	@Autowired
	private EmployerConverter employerConverter;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<EmployerDTO> findAll() {
		List<EmployerDTO> models = new ArrayList<>();
		List<EmployerEntity> entities = employerRepository.findAll();
		for (EmployerEntity item : entities) {
			EmployerDTO userModel = employerConverter.toDto(item);
			models.add(userModel);
		}
		return models;
	}
	
	@Override
	public EmployerDTO findById(long id) {
		EmployerEntity entity = employerRepository.findOne(id);
		return employerConverter.toDto(entity);
	}
	
	@Override
	@Transactional
	public EmployerDTO save(EmployerDTO dto) {
		EmployerEntity employerEntity = new EmployerEntity();
		UserEntity userEntity = new UserEntity();
		if (dto.getId() != null) {
			EmployerEntity oldApplicant = employerRepository.findOne(dto.getId());
			employerEntity = employerConverter.toEntity(oldApplicant, dto);
		} else {
			employerEntity = employerConverter.toEntity(dto);
			
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
			
			employerEntity.setUser(userEntity);
		}
		return employerConverter.toDto(employerRepository.save(employerEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			employerRepository.delete(id);
		}
	}

	@Override
	public void updatePackageService(Long emId, Long serId) {
		// TODO Auto-generated method stub
		EmployerEntity entity = employerRepository.findOne(emId);
		if(entity != null ) {
			entity.setServices(serId);
			employerRepository.save(entity);
			System.out.println("Update Succsses");
			System.out.println(entity.getServices().getId());
		}
		
		
		
	}
	
}
