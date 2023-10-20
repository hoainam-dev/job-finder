package com.jobfinder.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.jobfinder.dto.RoleDTO;

public interface IRoleService {
	List<RoleDTO> findAll(Pageable pageable);
	int getTotalItem();
	RoleDTO findById(long id);
	RoleDTO save(RoleDTO dto);
	void delete(long[] ids);
}

