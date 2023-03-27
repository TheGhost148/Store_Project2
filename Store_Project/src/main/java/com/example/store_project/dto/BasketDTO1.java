package com.example.store_project.dto;

import java.util.List;

public class BasketDTO1 {
    private List<Integer> productIds;

    public BasketDTO1() {
    }

    public BasketDTO1(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
}
