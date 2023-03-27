package com.example.store_project.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ProductBatch {
    @Id
    @SequenceGenerator(name = "product_batch_sequence_generator",
            sequenceName = "product_batch_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private Integer quantity;
    private BigDecimal price;
    @OneToOne
    private Product product;

    public ProductBatch() {
    }

    public ProductBatch(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        this.price = product.getPrice().multiply(new BigDecimal(this.quantity));
    }

    public ProductBatch(Integer quantity, BigDecimal price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
