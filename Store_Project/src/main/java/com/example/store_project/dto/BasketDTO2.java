package com.example.store_project.dto;

import com.example.store_project.domain.model.Product;

import java.util.List;

public class BasketDTO2 {
    private List<Product> products;

    public BasketDTO2() {
    }

    public BasketDTO2(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
