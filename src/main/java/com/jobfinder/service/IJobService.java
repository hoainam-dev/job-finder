package com.jobfinder.service;

import java.util.List;

import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.CategoryEntity;

public interface IJobService {
	
	List<JobDTO> findByCategoryId(Long categoryId);
	JobDTO findById(Long Id);
	List<JobDTO> findByCategory(CategoryEntity category);
	JobDTO save(JobDTO dto);
	List<JobDTO> findAll();
	List<JobDTO> filter(Long categoryId, String type, int salary, String location);
}
