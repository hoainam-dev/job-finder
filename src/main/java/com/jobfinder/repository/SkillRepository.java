package com.jobfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobfinder.entity.SkillEntity;


public interface SkillRepository extends JpaRepository<SkillEntity, Long>{
}
