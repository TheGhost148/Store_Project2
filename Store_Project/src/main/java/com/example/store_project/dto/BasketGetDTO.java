package com.example.store_project.dto;

import com.example.store_project.domain.model.ProductBatch;

import java.util.ArrayList;
import java.util.List;

public class BasketGetDTO {
    private List<ProductBatch> productBatches = new ArrayList<>();

    public BasketGetDTO() {
    }

    public BasketGetDTO(List<ProductBatch> productBatches) {
        this.productBatches = productBatches;
    }

    public List<ProductBatch> getProductBatches() {
        return productBatches;
    }

    public void setProductBatches(List<ProductBatch> productBatches) {
        this.productBatches = productBatches;
    }
}
