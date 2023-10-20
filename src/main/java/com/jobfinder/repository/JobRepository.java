package com.jobfinder.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobfinder.entity.JobEntity;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long>{
}