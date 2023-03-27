package com.example.store_project.dto;

import com.example.store_project.domain.model.Product;
import com.example.store_project.domain.model.Review;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.List;

public class FullProductDTO {
    private String category;
    private String subCategory;
    private String baseDescription;
    private String description;
    private String brandName;
    private List<Review> reviews;
    private BigDecimal price;
    private Integer brandId;
    private Integer reviewsCount;
    private BigDecimal reviewsAvg;
    private Integer categoryId;
    private Integer subCategoryId;
    private String pic;
    private Integer id;
    private String name;

    public FullProductDTO() {
    }

    public FullProductDTO(Integer id, String category, Integer categoryId, String subCategory,
                          Integer subCategoryId, String baseDescription, String description,
                          String brandName, Integer brandId, List<Review> reviews, BigDecimal price,
                          Integer reviewsCount, BigDecimal reviewsAvg, String pic, String name) {
        this.category = category;
        this.subCategory = subCategory;
        this.baseDescription = baseDescription;
        this.description = description;
        this.brandName = brandName;
        this.reviews = reviews;
        this.price = price;
        this.brandId = brandId;
        this.reviewsCount = reviewsCount;
        this.reviewsAvg = reviewsAvg;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.pic = pic;
        this.name = name;
        this.id = id;
    }

    public FullProductDTO(Product product) {
//        this.id = product.getId();
//        this.category = product.getCategory().getName();
//        this.categoryId = product.getCategory().getId();
//        this.subCategory = product.getSubCategory().getName();
//        this.subCategoryId = product.getSubCategory().getId();
//        this.brandName = product.getBrand().getName();
//        this.brandId = product.getBrand().getId();
//        this.reviews = product.getReviews();
//        this.price = product.getPrice();
//        this.reviewsCount = product.getReviewsCount();
//        this.reviewsAvg = product.getReviewsAvg();
//        this.pic = product.getPic();
//        this.name = product.getName();
//        this.baseDescription = product.getBaseDescription();
//        this.description = product.getDescription();

        this(
                product.getId(),
                product.getCategory().getName(),
                product.getCategory().getId(),
                product.getSubCategory().getName(),
                product.getSubCategory().getId(),
                product.getBaseDescription(),
                product.getDescription(),
                product.getBrand().getName(),
                product.getBrand().getId(),
                product.getReviews(),
                product.getPrice(),
                product.getReviewsCount(),
                product.getReviewsAvg(),
                product.getPic(),
                product.getName()
        );

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(Integer reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public Number getReviewsAvg() {
        return reviewsAvg;
    }

    public void setReviewsAvg(BigDecimal reviewsAvg) {
        this.reviewsAvg = reviewsAvg;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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
