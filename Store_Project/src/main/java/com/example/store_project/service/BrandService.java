package com.example.store_project.service;

import com.example.store_project.domain.model.Brand;
import com.example.store_project.domain.model.Review;
import com.example.store_project.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository repository;

    public List<Brand> getAll(){
        return repository.findAll();
    }

    public Brand getById(int id) {
        return repository.findById((id)).get();
    }
}
