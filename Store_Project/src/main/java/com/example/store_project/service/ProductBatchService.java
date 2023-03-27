package com.example.store_project.service;

import com.example.store_project.domain.model.ProductBatch;
import com.example.store_project.repository.ProductBatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBatchService {
    @Autowired
    private ProductBatchRepository repository;

    public ProductBatch save(ProductBatch productBatch) {
        return repository.save(productBatch);
    }

    public void removeById(Integer id) {
        repository.deleteById(id);
    }
}
