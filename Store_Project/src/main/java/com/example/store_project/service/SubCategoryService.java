package com.example.store_project.service;

import com.example.store_project.domain.model.SubCategory;
import com.example.store_project.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryService{
    @Autowired
    private SubCategoryRepository repository;

    public List<SubCategory> getAll(Optional<Integer> categoryId){
        return repository.getAll(
                categoryId.orElse(null)
        );
    }

    public SubCategory getById(int id) {
        return repository.findById(id).get();
    }
}
