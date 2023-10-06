package com.jobfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobfinder.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{

}
