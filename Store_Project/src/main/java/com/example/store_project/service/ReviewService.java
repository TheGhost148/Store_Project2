package com.example.store_project.service;

import com.example.store_project.domain.model.Review;
import com.example.store_project.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    public List<Review> getAll(){
        return repository.findAll();
    }

    public Review save(Review review){
        return repository.save(review);
    }

    public List<Review> getAllByProductId(Integer productId) {
        return repository.findAllByProductId(productId);
    }
}
