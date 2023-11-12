package com.jobfinder.service;

import java.util.List;

import com.jobfinder.dto.JobDTO;

public interface IJobService {
	
	JobDTO findById(Long Id);

	JobDTO save(JobDTO dto);
	
	List<JobDTO> findAll();
	
	List<JobDTO> filter(Long categoryId, String type, int salary, String location);

	List<JobDTO> findByTitle(String keyword);
	
}
