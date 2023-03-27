package com.example.store_project.dto;

import com.example.store_project.domain.model.SubCategory;

public class SubCategoryGetDTO {
    private Integer id;
    private String name;
    private Integer categoryId;
    private Integer orderId;

    public SubCategoryGetDTO() {
    }

    public SubCategoryGetDTO(Integer id, String name, Integer categoryId, Integer orderId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.orderId = orderId;
    }

    public SubCategoryGetDTO(SubCategory subCategory) {
        this(
                subCategory.getId(),
                subCategory.getName(),
                subCategory.getCategoryId(),
                subCategory.getOrderId()
        );
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
}
