package com.jobfinder.service;

import java.util.List;
import java.security.Principal;

import com.jobfinder.dto.ApplicantDTO;
import com.jobfinder.dto.JobDTO;

public interface IApplicantService {
    ApplicantDTO findByPrincipal(Principal principal);
  
    boolean hasAlreadyApplied(Long applicantId, Long jobId);
    boolean applyForJob(ApplicantDTO applicantDTO, JobDTO jobDTO);
    
    List<JobDTO> findAppliedJobs(Long applicantId);
    ApplicantDTO findByUsername(String username);
    
    
	ApplicantDTO findById(Long id);
	ApplicantDTO findByUserId(Long id);
	List<ApplicantDTO> findAll();
	ApplicantDTO save(ApplicantDTO dto);
	void delete(long[] ids);
}
