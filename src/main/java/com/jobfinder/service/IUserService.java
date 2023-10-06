package com.jobfinder.service;

import com.jobfinder.dto.UserDTO;

public interface IUserService {
	UserDTO findById(long id);
	UserDTO findOneByUserNameAndStatus(String userName, int status);
	UserDTO save(UserDTO dto);
	void delete(long[] ids);
}
