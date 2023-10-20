package com.jobfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobfinder.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	List<RoleEntity> findAllById(List<Long> ids);
}
