package com.jobfinder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobfinder.converter.UserConverter;
import com.jobfinder.dto.UserDTO;
import com.jobfinder.entity.RoleEntity;
import com.jobfinder.entity.UserEntity;
import com.jobfinder.repository.RoleRepository;
import com.jobfinder.repository.UserRepository;
import com.jobfinder.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private RoleRepository roleRepository;
	
	

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> models = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll();
		for (UserEntity item : entities) {
			UserDTO userModel = userConverter.toDto(item);
			models.add(userModel);
		}

		return models;
	}


	@Override
	public UserDTO findById(long id) {
		UserEntity entity = userRepository.findOne(id);
		return userConverter.toDto(entity);
	}
	
	@Override
	public UserDTO findOneByUserNameAndStatus(String userName, int status) {
		UserEntity entity = userRepository.findOneByUserNameAndStatus(userName, 1);
		return userConverter.toDto(entity);
	}

	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		UserEntity userEntity = new UserEntity();
		if (dto.getId() != null) {
			UserEntity oldUser = userRepository.findOne(dto.getId());
			userEntity = userConverter.toEntity(oldUser, dto);
		} else {
			userEntity = userConverter.toEntity(dto);
			
			List<RoleEntity> roles = new ArrayList<>();
			roles.add(roleRepository.findOne(dto.getRoleId()));
			userEntity.setRoles(roles);
			
			userEntity.setStatus(1);
		}
		return userConverter.toDto(userRepository.save(userEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			userRepository.delete(id);
		}
	}
}
