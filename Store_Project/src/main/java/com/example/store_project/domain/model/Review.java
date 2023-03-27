package com.example.store_project.domain.model;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @SequenceGenerator(name = "review_sequence_generator",
            sequenceName = "review_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String username;
    private Integer productId;
    private Integer rating;
    private String comment;

    public Review() {
    }

    public Review(String username, Integer productId, Integer rating, String comment) {
        this.username = username;
        this.productId = productId;
        this.rating = rating;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
