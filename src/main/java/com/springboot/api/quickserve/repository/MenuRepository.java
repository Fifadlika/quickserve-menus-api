package com.springboot.api.quickserve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.api.quickserve.model.entity.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
	
}
