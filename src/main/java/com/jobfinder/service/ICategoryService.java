package com.jobfinder.service;

import java.util.List;

import com.jobfinder.entity.CategoryEntity;

public interface ICategoryService {
	List<CategoryEntity> getAllCategories();
	public CategoryEntity getCategoryById(Long categoryId);
}
