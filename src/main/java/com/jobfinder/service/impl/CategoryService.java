package com.jobfinder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobfinder.entity.CategoryEntity;
import com.jobfinder.repository.CategoryRepository;
import com.jobfinder.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryEntity> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public CategoryEntity getCategoryById(Long categoryId) {
		return categoryRepository.findById(categoryId).orElse(null);
	}
}