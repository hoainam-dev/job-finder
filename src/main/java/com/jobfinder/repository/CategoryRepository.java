package com.jobfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobfinder.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

}