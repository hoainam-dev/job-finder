package com.jobfinder.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobfinder.entity.CategoryEntity;
import com.jobfinder.entity.JobEntity;


public interface JobRepository extends JpaRepository<JobEntity, Long>{

	List<JobEntity> findByCategoryId(Long categoryId);
	
	List<JobEntity> findByCategoryContaining(CategoryEntity category);
	

}