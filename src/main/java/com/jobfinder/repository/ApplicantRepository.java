package com.jobfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobfinder.entity.ApplicantEntity;


public interface ApplicantRepository extends JpaRepository<ApplicantEntity, Long>{
}
