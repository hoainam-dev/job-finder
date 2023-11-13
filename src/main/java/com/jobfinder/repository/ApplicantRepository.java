package com.jobfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobfinder.entity.ApplicantEntity;
import com.jobfinder.entity.UserEntity;

public interface ApplicantRepository extends JpaRepository<ApplicantEntity, Long>{
	 ApplicantEntity findByUser(UserEntity user);
	 ApplicantEntity findByUser_UserName(String username);
	 
}
