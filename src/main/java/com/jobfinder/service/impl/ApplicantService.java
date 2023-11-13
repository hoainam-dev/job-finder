package com.jobfinder.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobfinder.converter.ApplicantConverter;
import com.jobfinder.converter.JobConverter;
import com.jobfinder.converter.UserConverter;
import com.jobfinder.dto.ApplicantDTO;
import com.jobfinder.dto.JobDTO;
import com.jobfinder.dto.UserDTO;
import com.jobfinder.entity.ApplicantEntity;
import com.jobfinder.entity.JobEntity;
import com.jobfinder.entity.RoleEntity;
import com.jobfinder.entity.UserEntity;
import com.jobfinder.repository.ApplicantRepository;
import com.jobfinder.repository.JobRepository;
import com.jobfinder.repository.RoleRepository;
import com.jobfinder.repository.UserRepository;
import com.jobfinder.service.IApplicantService;

import javassist.bytecode.stackmap.TypeData.ClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ApplicantService implements IApplicantService{
	private static final Logger logger = LoggerFactory.getLogger(ClassName.class);

	@Autowired
	private ApplicantRepository applicantRepository;

	@Autowired
	private ApplicantConverter applicantConverter;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	 @Autowired
	 private JobRepository jobRepository;
	 
	 @Autowired
	 private JobConverter jobConverter;
	 	

	 @Override
	    public ApplicantDTO findByUsername(String username) {
	        UserEntity userEntity = userRepository.findOneByUserName(username);
	        if (userEntity != null) {
	            return applicantConverter.toDto(userEntity.getApplicant());
	        }
	        return null;
	    }

	 
	 @Override
	    public ApplicantDTO findByPrincipal(Principal principal) {
	        String username = principal.getName();
	        UserEntity userEntity = userRepository.findOneByUserName(username);
	        ApplicantEntity applicantEntity = applicantRepository.findByUser(userEntity);
	        return applicantConverter.toDto(applicantEntity);
	    }
	 @Override
	    public boolean hasAlreadyApplied(Long applicantId, Long jobId) {
	        ApplicantEntity applicantEntity = applicantRepository.findOne(applicantId);
	        JobEntity jobEntity = jobRepository.findOne(jobId);

	        return applicantEntity.getAppliedJobs().contains(jobEntity);
	    }
	 @Override
	    @Transactional
	    public boolean applyForJob(ApplicantDTO applicantDTO, JobDTO jobDTO) {
	        if (hasAlreadyApplied(applicantDTO.getId(), jobDTO.getId())) {
	            return false;
	        }
	        ApplicantEntity applicantEntity = applicantRepository.findOne(applicantDTO.getId());
	        JobEntity jobEntity = jobRepository.findOne(jobDTO.getId());
	        List<JobEntity> jobs = new ArrayList<>();
	        jobs.add(jobEntity);
	        applicantEntity.setAppliedJobs(jobs);
	        applicantRepository.save(applicantEntity);

	        return true;
	    }

	 @Override
	 public List<JobDTO> findAppliedJobs(Long applicantId) {
	     List<JobDTO> jobDTOList = new ArrayList<>();
	     ApplicantEntity applicant = applicantRepository.findOne(applicantId); 
	     if (applicant != null) {
	         List<JobEntity> appliedJobs = applicant.getAppliedJobs();
	         for (JobEntity job : appliedJobs) {
	             jobDTOList.add(jobConverter.toDto(job));
	         }
	     } 
	     return jobDTOList;
	 }

	@Override
	public List<ApplicantDTO> findAll() {
		List<ApplicantDTO> models = new ArrayList<>();
		List<ApplicantEntity> entities = applicantRepository.findAll();
		for (ApplicantEntity item : entities) {
			ApplicantDTO userModel = applicantConverter.toDto(item);
			models.add(userModel);
		}
		return models;
	}
	
	@Override
	public ApplicantDTO findById(long id) {
		ApplicantEntity entity = applicantRepository.findOne(id);
		return applicantConverter.toDto(entity);
	}
	
	@Override
	@Transactional
	public ApplicantDTO save(ApplicantDTO dto) {
		ApplicantEntity applicantEntity = new ApplicantEntity();
		UserEntity userEntity = new UserEntity();
		if (dto.getId() != null) {
			ApplicantEntity oldApplicant = applicantRepository.findOne(dto.getId());
			applicantEntity = applicantConverter.toEntity(oldApplicant, dto);
		} else {
			applicantEntity = applicantConverter.toEntity(dto);
			
			UserDTO userDTO = new UserDTO();
			userDTO.setUserName(dto.getUserName());
			userDTO.setPassword(dto.getPassword());
			userDTO.setFirstName(dto.getFirstName());
			userDTO.setLastName(dto.getLastName());
			userDTO.setEmail(dto.getEmail());
			
			userEntity = userConverter.toEntity(userDTO);
			
			List<RoleEntity> roles = new ArrayList<>();
			roles.add(roleRepository.findOne(dto.getRoleId()));
			userEntity.setRoles(roles);
			
			userEntity.setStatus(1);
			//save user
			userRepository.save(userEntity);
			
			applicantEntity.setUser(userEntity);
		}
		return applicantConverter.toDto(applicantRepository.save(applicantEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			applicantRepository.delete(id);
		}
	}
}
