package com.jobfinder.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.jobfinder.dto.JobDTO;

public interface IJobService {
	
	JobDTO findById(Long Id);

	JobDTO save(JobDTO dto);
	
	List<JobDTO> findAll();
	
	List<JobDTO> findAll(Pageable pageable);
	
	int getTotalItem();
	
	List<JobDTO> filter(Pageable pageable, Long categoryId, String type, int salary, String location);

	List<JobDTO> findByTitle(String keyword);
	
	void deleteJobs(List<Long> jobIds);
	
	List<JobDTO> findByTitle(Pageable pageable, String keyword);
	
	List<JobDTO> findByEmployerId(Long employer_id);
	
}
