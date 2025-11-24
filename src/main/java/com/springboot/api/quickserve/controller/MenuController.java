package com.springboot.api.quickserve.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.quickserve.model.dto.CreateMenuRequest;
import com.springboot.api.quickserve.model.dto.MenuDto;
import com.springboot.api.quickserve.service.MenuService;


@RestController
@RequestMapping("/menus")
public class MenuController {
	
	private final MenuService menuService;
	
	
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@GetMapping
	public List<MenuDto> listAll() {
		return menuService.listAll();
	}
	
	@GetMapping("/{id}")
	public MenuDto get(@PathVariable Long id) {
		return menuService.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<MenuDto> create(@RequestBody CreateMenuRequest req) {
		MenuDto created = menuService.create(req);
		return ResponseEntity.status(201).body(created);
	}
	
	@PutMapping("/{id}")
	public MenuDto update(@PathVariable Long id, @RequestBody CreateMenuRequest req) {
		return menuService.update(id, req);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		menuService.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
