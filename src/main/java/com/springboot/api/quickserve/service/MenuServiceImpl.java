package com.springboot.api.quickserve.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.api.quickserve.model.dto.CreateMenuRequest;
import com.springboot.api.quickserve.model.dto.MenuDto;
import com.springboot.api.quickserve.model.entity.CategoryEntity;
import com.springboot.api.quickserve.model.entity.MenuEntity;
import com.springboot.api.quickserve.repository.CategoryRepository;
import com.springboot.api.quickserve.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService{

    private final MenuRepository menuRepo;
    private final CategoryRepository categoryRepo;

    public MenuServiceImpl(MenuRepository menuRepo, CategoryRepository categoryRepo) {
        this.menuRepo = menuRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<MenuDto> listAll() {
        return menuRepo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public MenuDto getById(Long id) {
        return menuRepo.findById(id).map(this::toDto).orElseThrow(() -> new RuntimeException("Menu not found: " + id));
    }

    @Override
    @Transactional
    public MenuDto create(CreateMenuRequest req) {
    	if (req == null) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mana payloadnya cok");
    	}
    	if (req.getCategoryId() == null) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "jangan lupa isi categoryId yaw");
    	}
        CategoryEntity cat = categoryRepo.findById(req.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found: " + req.getCategoryId()));
        MenuEntity e = new MenuEntity();
        e.setName(req.getName());
        e.setPrice(req.getPrice());
        e.setAvailable(req.getAvailable() == null ? true : req.getAvailable());
        e.setCategory(cat);
        MenuEntity saved = menuRepo.save(e);
        return toDto(saved);
    }

    @Override
    @Transactional
    public MenuDto update(Long id, CreateMenuRequest req) {
        MenuEntity e = menuRepo.findById(id).orElseThrow(() -> new RuntimeException("Menu not found: " + id));
        if (req.getName() != null) e.setName(req.getName());
        if (req.getPrice() != null) e.setPrice(req.getPrice());
        if (req.getAvailable() != null) e.setAvailable(req.getAvailable());
        if (req.getCategoryId() != null) {
            CategoryEntity cat = categoryRepo.findById(req.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found: " + req.getCategoryId()));
            e.setCategory(cat);
        }
        MenuEntity saved = menuRepo.save(e);
        return toDto(saved);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!menuRepo.existsById(id)) throw new RuntimeException("Menu not found: " + id);
        menuRepo.deleteById(id);
    }

    private MenuDto toDto(MenuEntity e) {
        String catName = e.getCategory() == null ? null : e.getCategory().getName();
        return new MenuDto(e.getId(), e.getName(), e.getPrice(), e.isAvailable(), catName);
    }
}
