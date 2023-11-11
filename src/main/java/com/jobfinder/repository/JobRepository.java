package com.jobfinder.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobfinder.dto.JobDTO;
import com.jobfinder.entity.JobEntity;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long>{

	List<JobEntity> findByTitleContaining(String keyword);
	
}