package com.jobfinder.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobfinder.entity.CategoryEntity;
import com.jobfinder.entity.JobEntity;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long>{

	List<JobEntity> findByCategoryId(Long categoryId);
	
	List<JobEntity> findByTitleContaining(String keyword);
	
	List<JobEntity> findByLocationContaining(String location);
	
	List<JobEntity> findByPositionContaining(String position);
	
	List<JobEntity> findJobBySalaryContaining(int minSalary, int maxSalary);
	
	List<JobEntity> findByCategoryContaining(Long categoryId);
	
	List<JobEntity> findByTitleAndCategoryContaining(String keyword, Long categoryId);

}