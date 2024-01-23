package com.jobfinder.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.jobfinder.dto.ApplicantDTO;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.JobEntity;

public interface IJobService {
	
	JobDTO findById(Long Id);

	JobDTO save(JobDTO dto);
	
	List<JobDTO> findAll();
	
	List<JobDTO> findAll(Pageable pageable);
	
	int getTotalItem();
	
	List<JobDTO> filter(Pageable pageable, Long categoryId, String type, int salary, String location);
	
	void deleteJobs(List<Long> jobIds);
	
	List<JobDTO> findByTitle(Pageable pageable, String keyword);
	
	List<JobDTO> findByEmployerId(Long employer_id);
	
	List<ApplicantDTO> findApplicantsForJob(Long jobId);

	JobDTO update(Long jobId);

	JobDTO update(Long jobId, JobDTO jobDTO);

	JobDTO update(JobDTO dto);

	void deleteJob(Long jobId);
	
}
