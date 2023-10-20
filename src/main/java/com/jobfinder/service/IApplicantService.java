package com.jobfinder.service;

import java.util.List;

import com.jobfinder.dto.ApplicantDTO;

public interface IApplicantService {
	ApplicantDTO findById(long id);
	List<ApplicantDTO> findAll();
	ApplicantDTO save(ApplicantDTO dto);
	void delete(long[] ids);
}
