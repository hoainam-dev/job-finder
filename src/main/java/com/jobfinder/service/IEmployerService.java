package com.jobfinder.service;

import java.util.List;

import com.jobfinder.dto.EmployerDTO;

public interface IEmployerService {
	EmployerDTO findById(long id);
	List<EmployerDTO> findAll();
	EmployerDTO save(EmployerDTO dto);
	void delete(long[] ids);
}
