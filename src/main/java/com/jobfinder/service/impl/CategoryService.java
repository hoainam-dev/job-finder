package com.jobfinder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jobfinder.entity.CategoryEntity;
import com.jobfinder.repository.CategoryRepository;
import com.jobfinder.service.ICategoryService;

public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryEntity> getAllCategories() {
		return categoryRepository.findAll();
	}

//	@Override
//	public void saveCategory(CategoryEntity categoryEntity) {
//		categoryRepository.save(categoryEntity);
//		
//	}
//
//	@Override
//	public CategoryEntity getCategoryById(Long id) {
//		return categoryRepository.findById(id);
//	}
//
//	@Override
//	public void deleteCategoryById(Long id) {
//		categoryRepository.deleteById(id);
//		
//	}
	
	

}
