package com.jobfinder.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jobfinder.entity.ApplicantEntity;
import com.jobfinder.entity.JobEntity;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long>{

	@Query("SELECT j FROM JobEntity j JOIN j.applicants a") 
	List<JobEntity> findAllAppliedJobs();
	
	@Query("SELECT j.applicants FROM JobEntity j WHERE j.id = :jobId")
	List<ApplicantEntity> findApplicantsByJobId(@Param("jobId") Long jobId);

	Page<JobEntity> findByCategoryId(Pageable pageable, Long category_id);
	Page<JobEntity> findBySalary(Pageable pageable, int salary);
	Page<JobEntity> findByLocation(Pageable pageable, String location);
	Page<JobEntity> findByType(Pageable pageable, String type);
	List<JobEntity> findByTitleContaining(Pageable pageable, String keyword);
	List<JobEntity> findByEmployerId(Long employer_id);

}