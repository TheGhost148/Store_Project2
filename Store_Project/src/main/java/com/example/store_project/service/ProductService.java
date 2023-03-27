package com.example.store_project.service;

import com.example.store_project.domain.model.Product;
import com.example.store_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product getById(Integer id) {
//        return repository.findById(id).get();
          return repository.get(id);
    }

    public List<Product> getAll(
            String name, Integer brandId, BigDecimal priceFrom,
            BigDecimal priceUntil, BigDecimal reviewsAvg, Integer categoryId,
            Integer subCategoryId, PageRequest pageRequest
    ){
//        return repository.findAll();
        if(pageRequest == null) {
            return repository.getAll(name, brandId, priceFrom, priceUntil, reviewsAvg, categoryId, subCategoryId);
        } else {
            return repository.getAll(name, brandId, priceFrom, priceUntil, reviewsAvg, categoryId, subCategoryId, pageRequest);
        }
    }

//    public Product update(Integer id, Product product)
//    {
//        Product updatedProduct = this.getById(id);
//
//        updatedProduct.setName(product.getName());
//        updatedProduct.setCategory(product.getCategory());
//
//        repository.save(updatedProduct);
//
//        return updatedProduct;
//    }
//
//    public void delete(Integer id){
//        repository.deleteById(id);
//    }

    public Product updateProductPic(Integer productId) {
        Product product = this.getById(productId);

        product.setPic("pic");

        repository.save(product);

        return product;
    }
}
