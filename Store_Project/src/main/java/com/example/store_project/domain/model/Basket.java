package com.example.store_project.domain.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table
public class Basket {
    @Id
    @SequenceGenerator(name = "basket_id_sequence_generator",sequenceName = "basket_id_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
//    @ManyToMany
//    private List<Product> products;

    @OneToMany
    private List<ProductBatch> productBatches = new ArrayList<>();

    public Basket() {
    }

//    public Basket(List<Product> products) {
//        this.products = products;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ProductBatch> getProductBatches() {
        return productBatches;
    }

    public void setProductBatches(List<ProductBatch> productBatches) {
        this.productBatches = productBatches;
    }
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
}
