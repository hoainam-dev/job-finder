package com.jobfinder.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobfinder.entity.CategoryEntity;

import com.jobfinder.converter.JobConverter;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.JobEntity;
import com.jobfinder.repository.JobRepository;
import com.jobfinder.service.IJobService;
import com.jobfinder.util.SearchUtils;

@Service
public class JobService implements IJobService{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private JobConverter jobConverter;

	public JobService(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public List<JobEntity> getAllJobs() {
		return jobRepository.findAll();
	}
	
	@Override
	public List<JobEntity> getJobByCategoryId(Long categoryId) {
		return jobRepository.findByCategoryId(categoryId);
	}

	@Override
	public void createPost(JobEntity jobEntity) {
		jobRepository.save(jobEntity);
	}

	@Override
	public JobEntity getJobById(Long jobId) {
		return jobRepository.findJobById(jobId);
	}

	@Override
	public List<JobEntity> findByTitle(String keyword) {
	    String keywordWithoutAccents = SearchUtils.removeAccents(keyword);
	    return jobRepository.findByTitleContaining(keywordWithoutAccents);
		
	}

	@Override
	public List<JobEntity> findByTitleAndCategory(String keyword, CategoryEntity category) {
		return jobRepository.findByTitleAndCategoryContaining(keyword, category);
	}

	@Override
	public List<JobEntity> findByCategory(CategoryEntity category) {
		return jobRepository.findByCategoryContaining(category);
	}

	@Override
	public List<JobEntity> search(String keyword, Long categoryId) {
		if (StringUtils.isEmpty(keyword) && categoryId == null) {
			return jobRepository.findAll();
		} else if (!StringUtils.isEmpty(keyword) && categoryId == null) {
			return jobRepository.findByTitleContaining(keyword);
		} else if (StringUtils.isEmpty(keyword) && categoryId != null) {
			CategoryEntity category = new CategoryEntity();
			category.setId(categoryId);
			return jobRepository.findByCategoryContaining(category);
		} else {
			CategoryEntity category = new CategoryEntity();
			category.setId(categoryId);
			return jobRepository.findByTitleAndCategoryContaining(keyword, category);
		}
	}


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