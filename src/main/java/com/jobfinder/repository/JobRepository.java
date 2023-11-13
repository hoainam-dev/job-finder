package com.jobfinder.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jobfinder.entity.ApplicantEntity;
import com.jobfinder.entity.CategoryEntity;
import com.jobfinder.entity.JobEntity;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long>{

	List<JobEntity> findByCategoryId(Long categoryId);
	
	List<JobEntity> findByTitleContaining(String title);
	
	List<JobEntity> findByCategoryContaining(CategoryEntity category);
	
	List<JobEntity> findByTitleAndCategoryContaining (String keyword, CategoryEntity category);
	
	@Query("SELECT j FROM JobEntity j JOIN j.applicants a") 
	List<JobEntity> findAllAppliedJobs();
	
	@Query("SELECT j.applicants FROM JobEntity j WHERE j.id = :jobId")
	List<ApplicantEntity> findApplicantsByJobId(@Param("jobId") Long jobId);
}