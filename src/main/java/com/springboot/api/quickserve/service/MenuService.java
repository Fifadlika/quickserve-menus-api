package com.springboot.api.quickserve.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.api.quickserve.model.dto.CreateMenuRequest;
import com.springboot.api.quickserve.model.dto.MenuDto;

public interface MenuService {
	List<MenuDto> listAll();
    MenuDto getById(Long id);
    MenuDto create(CreateMenuRequest req);
    MenuDto update(Long id, CreateMenuRequest req);
    void delete(Long id);
}
