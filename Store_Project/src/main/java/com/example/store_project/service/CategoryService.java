package com.example.store_project.service;

import com.example.store_project.domain.model.Category;
import com.example.store_project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public List<Category> getAll(){
        return repository.findAll();
    }

    public Category getById(int id) {
        return repository.findById(id).get();
    }
}
