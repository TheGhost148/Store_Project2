package com.example.store_project.repository;

import com.example.store_project.domain.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer> {
    public List<SubCategory> getAllByCategoryId(Integer categoryId);

    @Query(
            "SELECT sc FROM SubCategory sc " +
                    "WHERE " +
                    "(:categoryId IS NULL OR sc.categoryId = :categoryId)"
    )
    public List<SubCategory> getAll(Integer categoryId);
}
