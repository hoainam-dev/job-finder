package com.jobfinder.service;

import java.util.List;

import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.CategoryEntity;

public interface IJobService {
	
	List<JobDTO> findByCategoryId(Long categoryId);
	
	JobDTO findById(Long Id);
	
	List<JobDTO> findByTitle(String keyword);
	
	List<JobDTO> findByLocation(String location);
	
	List<JobDTO> findByPosition(String position);
	
	List<JobDTO> findBySalary(String salaryStr);
	
	List<JobDTO> findByCategory(Long categoryId);
	
	List<JobDTO> findByTitleAndCategory(String keyword, Long categoryId);
	
	List<JobDTO> search(String keyword, Long categoryId);
	
	JobDTO save(JobDTO dto);
	
	List<JobDTO> findAll();
	
	List<JobDTO> filter(String category, String type);

}
