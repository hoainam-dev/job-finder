package com.jobfinder.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobfinder.converter.JobConverter;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.JobEntity;
import com.jobfinder.entity.SkillEntity;
import com.jobfinder.repository.CategoryRepository;
import com.jobfinder.repository.EmployerRepository;
import com.jobfinder.repository.JobRepository;
import com.jobfinder.repository.SkillRepository;
import com.jobfinder.service.IJobService;
import com.jobfinder.util.SearchUtils;

@Service
public class JobService implements IJobService {


	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private JobConverter jobConverter;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private EmployerRepository employerRepository;

	@Autowired
	private SkillRepository skillRepository;

	public JobService(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public JobDTO findById(Long id) {
		return jobConverter.toDto(jobRepository.findOne(id));
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
			List<SkillEntity> skills = new ArrayList<>();
			Date mysqlDate = null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = sdf.parse(dto.getDeadline());
				mysqlDate = new Date(date.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			jobEntity.setApplicationDeadline(mysqlDate);
			for (Long skillId : dto.getSkills()) {
				skills.add(skillRepository.findOne(skillId));
			}
			jobEntity.setSkills(skills);
			if (dto.getCategory_id() != null) {
				jobEntity.setCategory(categoryRepository.findOne(dto.getCategory_id()));
			}
			if (dto.getEmployer_id() != null) {
				jobEntity.setEmployer(employerRepository.findOne(dto.getEmployer_id()));
			}
		}
		return jobConverter.toDto(jobRepository.save(jobEntity));
	}

	@Override
	public List<JobDTO> filter(Long categoryId, String type, int salary, String location) {
		List<JobDTO> result = new ArrayList<>();
		if (categoryId != 0) {
			result = removeDuplicateJob(result, jobRepository.findByCategoryId(categoryId));
		}
		if (!type.equals("")) {
			result = removeDuplicateJob(result, jobRepository.findByType(type));
		}
		if (salary != 1) {
			result = removeDuplicateJob(result, jobRepository.findBySalary(salary));
		}
		if (!location.equals("")) {
			result = removeDuplicateJob(result, jobRepository.findByLocation(location));
		}
		return result;
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
	
	//Ham filter theo tung truong hop
	public List<JobDTO> removeDuplicateJob(List<JobDTO> jobDTO, List<JobEntity> jobEntity) {
		List<JobDTO> jobfiltered = new ArrayList<>();
		if(jobDTO.size()!=0) {
			for(int i=0 ; i<jobDTO.size() ; i++) {
				for(JobEntity job: jobEntity) {
					if(jobDTO.get(i).getId()==job.getId()) {
						jobfiltered.add(jobConverter.toDto(job));
					}
				}
			}
		}else {
			for(JobEntity job: jobEntity) {
				jobfiltered.add(jobConverter.toDto(job));
			}
		}
		return jobfiltered;
	}

	@Override
	public void deleteJobs(List<Long> jobIds) {
		for(Long jobId   : jobIds ) {
			jobRepository.delete(jobId);
		}
		
	}
}