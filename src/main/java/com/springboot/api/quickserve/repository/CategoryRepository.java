package com.springboot.api.quickserve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.api.quickserve.model.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

}
