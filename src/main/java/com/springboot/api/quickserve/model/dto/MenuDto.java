package com.springboot.api.quickserve.model.dto;

import java.math.BigDecimal;

public class MenuDto {
	private Long id;
	private String name;
	private BigDecimal price;
	private boolean isAvailable;
	private String categoryName;
	
	public MenuDto(Long id, String name, BigDecimal price, boolean isAvailable, String categoryName) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.isAvailable = isAvailable;
		this.categoryName = categoryName;
	}
	
	public Long getId() { return id; }
	public String getName() { return name; }
	public BigDecimal getPrice() { return price; }
	public boolean isAvailable() { return isAvailable; }
	public String getCategoryName() { return categoryName; }
	
	
}
