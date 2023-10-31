package com.jobfinder.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobfinder.converter.JobConverter;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.CategoryEntity;
import com.jobfinder.entity.EmployerEntity;
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
	public List<JobDTO> findByLocation(String location) {
		String locationWithoutAccents = SearchUtils.removeAccents(location);
		List<JobDTO> models = new ArrayList<>();
		List<JobEntity> jobs = jobRepository.findByLocationContaining(locationWithoutAccents);
		for (JobEntity item : jobs) {
			JobDTO userModel = jobConverter.toDto(item);
			models.add(userModel);
		}
		return models;
	}
	
	@Override
	public List<JobDTO> findByPosition(String position) {
		String positionWithoutAccents = SearchUtils.removeAccents(position);
		List<JobDTO> models = new ArrayList<>();
		List<JobEntity> jobs = jobRepository.findByPositionContaining(positionWithoutAccents);
		for (JobEntity item : jobs) {
			JobDTO userModel = jobConverter.toDto(item);
			models.add(userModel);
		}
		return models;
	}

	@Override
	public List<JobDTO> findBySalary(String salaryStr) {
		int salary = Integer.parseInt(salaryStr);
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<JobEntity> query = builder.createQuery(JobEntity.class);
		Root<JobEntity> root = query.from(JobEntity.class);
		Predicate predicate = builder.lessThanOrEqualTo(root.get("salary"), salary);
		query.where(predicate);
		List<JobEntity> jobs = entityManager.createQuery(query).getResultList();
		List<JobDTO> models = new ArrayList<>();
//		List<JobEntity> jobs = jobRepository.findJobBySalaryContaining(0, salary);
		for (JobEntity item : jobs) {
			JobDTO userModel = jobConverter.toDto(item);
			models.add(userModel);
		}
		return models;
	}

	@Override
	public List<JobDTO> findByTitleAndCategory(String keyword, Long categoryId ) {
		List<JobDTO> models = new ArrayList<>();
		List<JobEntity> jobs = jobRepository.findByTitleAndCategoryContaining(keyword, categoryId);
		for (JobEntity item : jobs) {
			JobDTO userModel = jobConverter.toDto(item);
			models.add(userModel);
		}
		return models;
	}

	@Override
	public List<JobDTO> findByCategory(Long categoryId) {
		List<JobDTO> models = new ArrayList<>();
		List<JobEntity> jobs = jobRepository.findByCategoryContaining(categoryId);
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
			List<JobEntity> jobs = jobRepository.findByCategoryContaining(categoryId);
			for (JobEntity item : jobs) {
				JobDTO userModel = jobConverter.toDto(item);
				models.add(userModel);
			}
			return models;
		} else {
			CategoryEntity category = new CategoryEntity();
			category.setId(categoryId);
			List<JobEntity> jobs = jobRepository.findByTitleAndCategoryContaining(keyword, categoryId);
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
	public List<JobDTO> filter(String category, String type) {
		List<JobDTO> result = new ArrayList<>();
		List<JobEntity> jobs = jobRepository.findAll();
		for (JobEntity job : jobs) {
            if (category != null && job.getCategory().getId().equals(Long.parseLong(category))) {
                if (type != null && job.getType().equalsIgnoreCase(type)) {
                    result.add(jobConverter.toDto(job));
                } else if (type == null) {
                    result.add(jobConverter.toDto(job));
                }
            }
        }
        
        return result;
	}

	@Override
	@Transactional
	public JobDTO save(JobDTO dto) {
	    JobEntity jobEntity;
	    if (dto.getId() != null) {
	        JobEntity oldJob = jobRepository.findOne(dto.getId());
	        jobEntity = jobConverter.toEntity(oldJob, dto);
	    } else {
	        jobEntity = jobConverter.toEntity(dto);
	    }
	    
	    if (dto.getCategory_id() != null) {
	        CategoryEntity category = categoryRepository.findOne(dto.getCategory_id());
	        if (category != null) {	
	            jobEntity.setCategory(category);;
	        } 
	    }
	    
	    if (dto.getEmployer_id() != null) {
	        EmployerEntity employer = employerRepository.findOne(dto.getEmployer_id());
	        if (employer != null) {
	            jobEntity.setEmployer(employer);
	        }
	    }
	    
	    JobEntity savedJobEntity = jobRepository.save(jobEntity);
	    return jobConverter.toDto(savedJobEntity);
	}
}