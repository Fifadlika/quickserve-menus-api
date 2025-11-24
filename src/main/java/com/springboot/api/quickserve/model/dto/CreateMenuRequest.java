package com.springboot.api.quickserve.model.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateMenuRequest {
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotNull(message = "Price is required")
	@Positive(message = "Price must be positive")
	private BigDecimal price;
	private String categoryName;
	@NotNull(message = "Category ID is required")
	private Long categoryId;
	private Boolean available;
	
	public CreateMenuRequest() { super(); }
	
	public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

	public Long getCategoryId() { return categoryId; }
	public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
	
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}
