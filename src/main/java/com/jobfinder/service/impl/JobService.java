package com.jobfinder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobfinder.converter.JobConverter;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.JobEntity;
import com.jobfinder.repository.JobRepository;
import com.jobfinder.service.IJobService;

@Service
public class JobService implements IJobService{
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private JobConverter jobConverter;


	@Override
	public List<JobEntity> getAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public void createPost(JobEntity jobEntity) {
		jobRepository.save(jobEntity);
	}

	@Override
	public List<JobDTO> findAll() {
		List<JobDTO> models = new ArrayList<>();
		List<JobEntity> entities = jobRepository.findAll();
		for (JobEntity item : entities) {
			JobDTO userModel = jobConverter.toDto(item);
			models.add(userModel);
		}
		return models;
	}
}