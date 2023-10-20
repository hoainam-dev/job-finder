package com.jobfinder.service;

import java.util.List;

import com.jobfinder.dto.UserDTO;

public interface IUserService {
	UserDTO findById(long id);
	List<UserDTO> findAll();
	UserDTO findOneByUserNameAndStatus(String userName, int status);
	UserDTO save(UserDTO dto);
	void delete(long[] ids);
}
