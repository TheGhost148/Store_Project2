package com.example.store_project.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
//@Table
public class Product {
    @Id
    @SequenceGenerator(name = "product_id_sequence_generator",
            sequenceName = "product_id_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private BigDecimal price;
    @ManyToOne
    private Brand brand;
    private Integer reviewsCount;
    private BigDecimal reviewsAvg;
    @OneToMany
    private List<Review> reviews;
    @ManyToOne
    private Category category;
    @ManyToOne
    private SubCategory subCategory;
    private String pic;
    private String name;

    private String baseDescription;

    private String description;


//    @ManyToMany(mappedBy = "products")
//    private List<Basket> baskets;

    public Product() {
    }

    public Product(BigDecimal price, Brand brand, Integer reviewsCount,
                   BigDecimal reviewsAvg, Category category,
                   SubCategory subCategory, String pic, String name,
                   String baseDescription, String description, List<Review> reviews) {
        this.price = price;
        this.brand = brand;
        this.reviewsCount = reviewsCount;
        this.reviewsAvg = reviewsAvg;
        this.category = category;
        this.subCategory = subCategory;
        this.pic = pic;
        this.name = name;
        this.baseDescription = baseDescription;
        this.description = description;
        this.reviews = reviews;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Integer getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(Integer reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public BigDecimal getReviewsAvg() {
        return reviewsAvg;
    }

    public void setReviewsAvg(BigDecimal reviewsAvg) {
        this.reviewsAvg = reviewsAvg;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getBaseDescription() {
        return baseDescription;
    }

    public void setBaseDescription(String baseDescription) {
        this.baseDescription = baseDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //    public List<Basket> getBaskets() {
//        return baskets;
//    }
//
//    public void setBaskets(List<Basket> baskets) {
//        this.baskets = baskets;
//    }
}
