package com.example.store_project.domain.model;

import jakarta.persistence.*;

@Entity
public class Category {
    private Integer orderId;

    @Id
    @SequenceGenerator(name = "category_id_sequence_generator",
            sequenceName = "category_id_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;

    public Category() {
    }

    public Category(Integer orderId, String name) {
        this.orderId = orderId;
        this.name = name;
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
