package com.example.store_project.domain.model;

import jakarta.persistence.*;

@Entity
public class SubCategory {
    private Integer categoryId;
    private Integer orderId;

    @Id
    @SequenceGenerator(name = "subcategory_id_sequence_generator",
            sequenceName = "subcategory_id_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;

    public SubCategory() {
    }

    public SubCategory(Integer categoryId, Integer orderId, String name) {
        this.categoryId = categoryId;
        this.orderId = orderId;
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
