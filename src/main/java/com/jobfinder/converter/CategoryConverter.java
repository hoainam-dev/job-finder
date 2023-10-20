package com.jobfinder.converter;

import org.springframework.stereotype.Component;

import com.jobfinder.dto.CategoryDTO;
import com.jobfinder.entity.CategoryEntity;

@Component
public class CategoryConverter {

	public CategoryDTO toDto(CategoryEntity entity) {
		CategoryDTO result = new CategoryDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		return result;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity result = new CategoryEntity();
		result.setName(dto.getName());
		return result;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto, CategoryEntity result) {
		result.setName(dto.getName());
		return result;
	}
}
