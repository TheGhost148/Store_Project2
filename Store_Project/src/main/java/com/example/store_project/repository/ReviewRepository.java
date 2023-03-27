package com.example.store_project.repository;

import com.example.store_project.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {
    public List<Review> findAllByProductId(Integer productId);
}
