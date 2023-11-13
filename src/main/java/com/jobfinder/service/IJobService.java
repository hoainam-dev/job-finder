package com.jobfinder.service;

import java.util.List;

import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.CategoryEntity;

public interface IJobService {
	
	List<JobDTO> findByCategoryId(Long categoryId);
	JobDTO findById(Long Id);
	List<JobDTO> findByTitle(String keyword);
	List<JobDTO> findByCategory(CategoryEntity category);
	List<JobDTO> findByTitleAndCategory(String keyword, CategoryEntity category);
	List<JobDTO> search(String keyword, Long categoryId);
	JobDTO save(JobDTO dto);
	List<JobDTO> findAll();
//test showall apply-job
	List<JobDTO> findAllAppliedJobs();
}
