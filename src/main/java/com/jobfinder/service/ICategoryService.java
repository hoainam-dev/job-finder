package com.jobfinder.service;

import java.util.List;

import com.jobfinder.dto.CategoryDTO;

public interface ICategoryService {
	List<CategoryDTO> findAll();
	public CategoryDTO findById(Long id);
}
