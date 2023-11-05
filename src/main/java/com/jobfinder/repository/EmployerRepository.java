package com.jobfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobfinder.entity.EmployerEntity;


public interface EmployerRepository extends JpaRepository<EmployerEntity, Long>{
}
