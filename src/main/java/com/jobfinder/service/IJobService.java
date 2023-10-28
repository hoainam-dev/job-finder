package com.jobfinder.service;

import java.util.List;

import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.JobEntity;

public interface IJobService {
	List<JobEntity> getAllJobs();
	public void createPost(JobEntity jobEntity);
	
	List<JobDTO> findAll();
}
