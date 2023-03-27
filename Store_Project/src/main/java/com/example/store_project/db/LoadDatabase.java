package com.example.store_project.db;

import com.example.store_project.domain.model.*;
import com.example.store_project.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

//    @Bean
//    CommandLineRunner initDatabaseWithProducts(ProductRepository repository) {
//
//        return args -> {
////            log.info("Preloading " + repository.save(new Product("Chips", Category.Food)));
////            log.info("Preloading " + repository.save(new Product("Teapot",Category.Appliance)));
//
//        };
//    }
//
//
//
//    @Bean
//    CommandLineRunner initDatabaseWithBaskets(BasketRepository repository, ProductService productService) {
//
//        return args -> {
////            log.info("Preloading " + repository.save(
////                    new Basket(List.of(productService.getById(1)))));
////            log.info("Preloading " + repository.save(
////                    new Basket(List.of(productService.getById(2)))));
//
//        };
//    }











    @Bean
    CommandLineRunner initDatabaseWithBrands(BrandRepository repository) {
        return args -> {
            log.info("Preloading: " + repository.save(new Brand("Brand1")));
            log.info("Preloading: " + repository.save(new Brand("Brand2")));
        };
    }

    @Bean
    CommandLineRunner initDatabaseWithCategories(CategoryRepository repository) {
        return args -> {
            log.info("Preloading: " + repository.save(new Category(1,"Category1")));
            log.info("Preloading: " + repository.save(new Category(2,"Category2")));
        };
    }

    @Bean
    CommandLineRunner initDatabaseWithSubCategories(SubCategoryRepository repository) {
        return args -> {
            log.info("Preloading: " + repository.save(new SubCategory(1,1,"SubCategory1A")));
            log.info("Preloading: " + repository.save(new SubCategory(1,2,"SubCategory2A")));
            log.info("Preloading: " + repository.save(new SubCategory(2,3,"SubCategory1B")));
            log.info("Preloading: " + repository.save(new SubCategory(2,4,"SubCategory1B")));
        };
    }

    @Bean
    CommandLineRunner initDatabaseWithReviews(ReviewRepository repository) {
        return args -> {
            log.info("Preloading: " + repository.save(new Review("user1",1,5,"comment1")));
            log.info("Preloading: " + repository.save(new Review("user2",1,5,"comment2")));
            log.info("Preloading: " + repository.save(new Review("user3",2,5,"comment3")));
            log.info("Preloading: " + repository.save(new Review("user4",3,5,"comment4")));

        };
    }

    @Bean
    CommandLineRunner initDatabaseWithProducts(ProductRepository productRepository, BrandRepository brandRepository, CategoryRepository categoryRepository,SubCategoryRepository subCategoryRepository, ReviewRepository reviewRepository) {
        return args -> {
            log.info("Preloading: " + productRepository.save(new Product(new BigDecimal(3.5),brandRepository.findById(1).get(),0,new BigDecimal(0),categoryRepository.findById(1).get(),subCategoryRepository.findById(1).get(),"somePic1","Product1","baseDescription1","description1", List.of(reviewRepository.findById(1).get(),reviewRepository.findById(2).get()))));
            log.info("Preloading: " + productRepository.save(new Product(new BigDecimal(4.5),brandRepository.findById(1).get(),0,new BigDecimal(0),categoryRepository.findById(1).get(),subCategoryRepository.findById(1).get(),"somePic2","Product2","baseDescription2","description2", List.of(reviewRepository.findById(3).get()))));
            log.info("Preloading: " + productRepository.save(new Product(new BigDecimal(5.5),brandRepository.findById(2).get(),0,new BigDecimal(0),categoryRepository.findById(2).get(),subCategoryRepository.findById(2).get(),"somePic3","Product3","baseDescription3","description3", List.of(reviewRepository.findById(4).get()))));
            log.info("Preloading: " + productRepository.save(new Product(new BigDecimal(6.5),brandRepository.findById(2).get(),0,new BigDecimal(0),categoryRepository.findById(2).get(),subCategoryRepository.findById(2).get(),"somePic4","Product4","baseDescription4","description4", new ArrayList<>())));
        };
    }


}