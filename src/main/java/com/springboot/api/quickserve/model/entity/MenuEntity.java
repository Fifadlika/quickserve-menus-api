package com.springboot.api.quickserve.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private boolean isAvailable = true;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public MenuEntity() {}

    public MenuEntity(String name, BigDecimal price, boolean isAvailable, CategoryEntity category) {
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.category = category;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public CategoryEntity getCategory() { return category; }
    public void setCategory(CategoryEntity category) { this.category = category; }
}
