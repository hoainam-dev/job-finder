package com.jobfinder.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobfinder.converter.JobConverter;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.CategoryEntity;
import com.jobfinder.entity.JobEntity;
import com.jobfinder.repository.CategoryRepository;
import com.jobfinder.repository.EmployerRepository;
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
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private EmployerRepository employerRepository;

	public JobService(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}
	
	@Override
	public List<JobDTO> findByCategoryId(Long categoryId) {
		List<JobDTO> models = new ArrayList<>();
		List<JobEntity> jobs = jobRepository.findByCategoryId(categoryId);
		for (JobEntity item : jobs) {
			JobDTO userModel = jobConverter.toDto(item);
			models.add(userModel);
		}
		return models;
	}

	@Override
	public JobDTO findById(Long id) {
		return jobConverter.toDto(jobRepository.findOne(id));
	}

	@Override
	public List<JobDTO> findByTitle(String keyword) {
	    String keywordWithoutAccents = SearchUtils.removeAccents(keyword);
	    List<JobDTO> models = new ArrayList<>();
		List<JobEntity> jobs = jobRepository.findByTitleContaining(keywordWithoutAccents);
		for (JobEntity item : jobs) {
			JobDTO userModel = jobConverter.toDto(item);
			models.add(userModel);
		}
		return models;
		
	}

	@Override
	public List<JobDTO> findByTitleAndCategory(String keyword, CategoryEntity category) {
		List<JobDTO> models = new ArrayList<>();
		List<JobEntity> jobs = jobRepository.findByTitleAndCategoryContaining(keyword, category);
		for (JobEntity item : jobs) {
			JobDTO userModel = jobConverter.toDto(item);
			models.add(userModel);
		}
		return models;
	}

	@Override
	public List<JobDTO> findByCategory(CategoryEntity category) {
		List<JobDTO> models = new ArrayList<>();
		List<JobEntity> jobs = jobRepository.findByCategoryContaining(category);
		for (JobEntity item : jobs) {
			JobDTO userModel = jobConverter.toDto(item);
			models.add(userModel);
		}
		return models;
	}

	@Override
	public List<JobDTO> search(String keyword, Long categoryId) {
		List<JobDTO> models = new ArrayList<>();
		if (StringUtils.isEmpty(keyword) && categoryId == null) {
			List<JobEntity> jobs = jobRepository.findAll();
			for (JobEntity item : jobs) {
				JobDTO userModel = jobConverter.toDto(item);
				models.add(userModel);
			}
			return models; 
		} else if (!StringUtils.isEmpty(keyword) && categoryId == null) {
			List<JobEntity> jobs = jobRepository.findByTitleContaining(keyword);
			for (JobEntity item : jobs) {
				JobDTO userModel = jobConverter.toDto(item);
				models.add(userModel);
			}
			return models;
		} else if (StringUtils.isEmpty(keyword) && categoryId != null) {
			CategoryEntity category = new CategoryEntity();
			category.setId(categoryId);
			List<JobEntity> jobs = jobRepository.findByCategoryContaining(category);
			for (JobEntity item : jobs) {
				JobDTO userModel = jobConverter.toDto(item);
				models.add(userModel);
			}
			return models;
		} else {
			CategoryEntity category = new CategoryEntity();
			category.setId(categoryId);
			List<JobEntity> jobs = jobRepository.findByTitleAndCategoryContaining(keyword, category);
			for (JobEntity item : jobs) {
				JobDTO userModel = jobConverter.toDto(item);
				models.add(userModel);
			}
			return models;
		}
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

	@Override
	@Transactional
	public JobDTO save(JobDTO dto) {
		JobEntity jobEntity = new JobEntity();
		if (dto.getId() != null) {
			JobEntity oldJob = jobRepository.findOne(dto.getId());
			jobEntity = jobConverter.toEntity(oldJob, dto);
		} else {
			jobEntity = jobConverter.toEntity(dto);
			if(dto.getCategory_id()!=null) {
				jobEntity.setCategory(categoryRepository.findOne(dto.getCategory_id()));
			}
			if(dto.getEmployer_id()!=null) {
				jobEntity.setEmployer(employerRepository.findOne(dto.getEmployer_id()));
			}
		}
		return jobConverter.toDto(jobRepository.save(jobEntity));
	}
}