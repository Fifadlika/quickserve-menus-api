package com.springboot.api.quickserve.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springboot.api.quickserve.model.entity.CategoryEntity;
import com.springboot.api.quickserve.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    private final CategoryRepository categoryRepository;
    
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    @GetMapping
    public List<CategoryEntity> listAll() {
        return categoryRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> get(@PathVariable Long id) {
        return categoryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<CategoryEntity> create(@RequestBody CategoryEntity category) {
        CategoryEntity saved = categoryRepository.save(category);
        return ResponseEntity.status(201).body(saved);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!categoryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        categoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}