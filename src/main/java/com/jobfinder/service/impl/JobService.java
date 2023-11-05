package com.jobfinder.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
			for(Long skillId: dto.getSkills()) {
				skills.add(skillRepository.findOne(skillId));
			}
			jobEntity.setSkills(skills);
			if(dto.getCategory_id()!=null) {
				jobEntity.setCategory(categoryRepository.findOne(dto.getCategory_id()));
			}
			if(dto.getEmployer_id()!=null) {
				jobEntity.setEmployer(employerRepository.findOne(dto.getEmployer_id()));
			}
		}
		return jobConverter.toDto(jobRepository.save(jobEntity));
	}

	@Override
	public List<JobDTO> filter(Long categoryId, String type, int salary, String location) {
		List<JobDTO> result = new ArrayList<>();
		List<JobDTO> jobs = new ArrayList<>();
		for(JobEntity job: jobRepository.findAll()) {
			jobs.add(jobConverter.toDto(job));
		}
		System.out.println("categoryId: "+categoryId);
		System.out.println("type: "+type);
		System.out.println("salary: "+salary);
		System.out.println("location: "+location);
		if(categoryId==0) {
			if(salary==1) {
				if(type.equals("")) {
					result = jobs.stream()
							.filter(i ->location.equals(location))
							.collect(Collectors.toList());
				}
				if(location.equals("")) {
					result = jobs.stream()
							.filter(i ->i.getType().equals(type))
							.collect(Collectors.toList());
				}
			}else {
				if(type.equals("")) {
					result = jobs.stream()
							.filter(i ->i.getSalary()==salary || location.equals(location))
							.collect(Collectors.toList());
				}
				if(location.equals("")) {
					result = jobs.stream()
							.filter(i ->i.getType().equals(type) || i.getSalary()==salary)
							.collect(Collectors.toList());
				}
			}
		}else {
			result = jobs.stream()
					.filter(i ->i.getType().equals(type) || i.getSalary()==salary || location.equals(location))
					.collect(Collectors.toList());
			if(type.equals("")) {
				result = jobs.stream()
						.filter(i ->i.getCategory_id()==categoryId || i.getSalary()==salary || location.equals(location))
						.collect(Collectors.toList());
			}
			if(location.equals("")) {
				result = jobs.stream()
						.filter(i ->i.getType().equals(type) || i.getSalary()==salary || i.getCategory_id()==categoryId)
						.collect(Collectors.toList());
			}
		}
		return result;
	}
	
	
}