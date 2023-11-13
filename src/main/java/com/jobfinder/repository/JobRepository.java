package com.jobfinder.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobfinder.entity.JobEntity;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long>{
	List<JobEntity> findByCategoryId(Long category_id);
	List<JobEntity> findBySalary(int salary);
	List<JobEntity> findByLocation(String location);
	List<JobEntity> findByType(String type);
	List<JobEntity> findByTitleContaining(String keyword);
	
}