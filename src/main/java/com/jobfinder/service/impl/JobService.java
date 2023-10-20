package com.jobfinder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobfinder.entity.JobEntity;
import com.jobfinder.repository.JobRepository;
import com.jobfinder.service.IJobService;

@Service
public class JobService implements IJobService{
	
	@Autowired
	private JobRepository jobRepository;


	@Override
	public List<JobEntity> getAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public void createPost(JobEntity jobEntity) {
		jobRepository.save(jobEntity);
	}
}