package com.jobfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobfinder.entity.PositionEntity;

@Repository
public interface PositionRepository extends JpaRepository<PositionEntity, Long>{
	List<PositionEntity> findByCategoryId(Long categoryId);
}