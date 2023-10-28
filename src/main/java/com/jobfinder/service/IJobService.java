package com.jobfinder.service;

import java.util.List;

import com.jobfinder.entity.CategoryEntity;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.JobEntity;

public interface IJobService {
	
	List<JobEntity> getAllJobs();
	
	List<JobEntity> getJobByCategoryId(Long categoryId);
	
	public void createPost(JobEntity jobEntity);
	
	JobEntity getJobById(Long jobId);
	
	List<JobEntity> findByTitle(String keyword);
	
	List<JobEntity> findByCategory(CategoryEntity category);
	
	List<JobEntity> findByTitleAndCategory(String keyword, CategoryEntity category);
	
	List<JobEntity> search(String keyword, Long categoryId);

	List<JobDTO> findAll();
}
