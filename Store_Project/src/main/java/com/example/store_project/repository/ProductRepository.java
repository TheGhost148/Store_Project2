package com.example.store_project.repository;

import com.example.store_project.domain.model.Category;
import com.example.store_project.domain.model.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    public List<Product> getProductsByCategory(Category category);

//    @Query("SELECT p,r FROM Product p LEFT JOIN Review r  on p.id = r.productId WHERE p.id = :productId")
    @Query("SELECT p FROM Product p WHERE p.id = :productId")
    public Product get(Integer productId);

    @Query("SELECT p FROM Product p " +
            "                 WHERE " +
            "                (:name IS NULL OR p.name = :name) " +
            "                AND (:brandId IS NULL OR p.brand.id = :brandId) " +
            "                AND (:priceFrom IS NULL OR p.price > :priceFrom) " +
            "                AND (:priceUntil IS NULL OR p.price < :priceUntil) " +
            "                AND (:reviewsAvg IS NULL OR p.reviewsAvg = :reviewsAvg) " +
            "                AND (:categoryId IS NULL OR p.category.id = :categoryId) " +
            "                AND (:subCategoryId IS NULL OR p.subCategory.id = :subCategoryId)")
    public List<Product> getAll(String name, Integer brandId, BigDecimal priceFrom,
                                BigDecimal priceUntil, BigDecimal reviewsAvg, Integer categoryId,
                                Integer subCategoryId);

    @Query("SELECT p FROM Product p " +
            "                 WHERE " +
            "                (:name IS NULL OR p.name = :name) " +
            "                AND (:brandId IS NULL OR p.brand.id = :brandId) " +
            "                AND (:priceFrom IS NULL OR p.price > :priceFrom) " +
            "                AND (:priceUntil IS NULL OR p.price < :priceUntil) " +
            "                AND (:reviewsAvg IS NULL OR p.reviewsAvg = :reviewsAvg) " +
            "                AND (:categoryId IS NULL OR p.category.id = :categoryId) " +
            "                AND (:subCategoryId IS NULL OR p.subCategory.id = :subCategoryId)")
    public List<Product> getAll(String name, Integer brandId, BigDecimal priceFrom,
                                                         BigDecimal priceUntil, BigDecimal reviewsAvg, Integer categoryId,
                                                         Integer subCategoryId, PageRequest pageRequest);
}
