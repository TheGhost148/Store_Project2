package com.example.store_project.service;

import com.example.store_project.dto.BasketPostDTO;
import com.example.store_project.domain.model.Basket;
import com.example.store_project.domain.model.ProductBatch;
import com.example.store_project.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    @Autowired
    private BasketRepository repository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductBatchService productBatchService;

    public Basket get(){
        if(!repository.findById(1).isPresent()) {
            repository.save(new Basket());
        }

        return repository.findById(1).get();
    }

    public Basket addToBasket(BasketPostDTO basketPostDTO){
        Basket basket = this.get();

        basket.getProductBatches().add(
                productBatchService.save(new ProductBatch(basketPostDTO.getQuantity(),
                        productService.getById(basketPostDTO.getProductId())))
                );

        repository.save(basket);

        return basket;
    }

    public Basket updateProductBatch(Integer productBatchId, Integer quantity) {
        Basket basket = this.get();

        List<ProductBatch> productBatches = basket.getProductBatches();

//        ProductBatch updatedProductBatch = productBatches
//                .stream()
//                .filter(productBatch ->
//                {return productBatch.getId() == productBatchId;})
//                .findFirst()
//                .get();
//
//        updatedProductBatch.setQuantity(basketPostDTO.getQuantity());

        for (ProductBatch productBatch : productBatches) {
            if (productBatch.getId() == productBatchId) {
                productBatch.setQuantity(quantity);
                productBatchService.save(productBatch);
                break;
            }
        }

        basket.setProductBatches(productBatches);

        repository.save(basket);

        return basket;
    }

    public Basket removeProductBatch(Integer productBatchId) {
        Basket basket = this.get();

        List<ProductBatch> productBatches = basket.getProductBatches();

        for (ProductBatch productBatch : productBatches) {
            if (productBatch.getId().equals(productBatchId)) {
                productBatches.remove(productBatch);
                productBatchService.removeById(productBatch.getId());
                break;
            }
        }

        basket.setProductBatches(productBatches);

        repository.save(basket);

        return basket;
    }


//    @Autowired
//    private ProductService productService;

//    public Basket getById(Integer id) {
//        return repository.findById(id).get();
//    }
//
//    public List<Basket> getAll(){
//        return repository.findAll();
//    }
//
//    public Basket update(Integer id, BasketDTO1 basketDTO1)
//    {
//        Basket updatedBasket = this.getById(id);
//
////        updatedBasket.setProducts(basketDTO.getProductIds()
////                .stream()
////                .map(product_id -> {return productService.getById(product_id);})
////                .collect(Collectors.toList()));
//
////        updatedBasket.getProducts().clear();
//
//        for (Integer product_id : basketDTO1.getProductIds()) {
////            updatedBasket.getProducts().add(productService.getById(product_id));
//        }
//
////        List<Product> updatedProductsList = new ArrayList<>();
////        for (Integer product_id : basketDTO.getProductIds()) {
////            updatedProductsList.add(productService.getById(product_id));
////        }
////
////        updatedBasket.setProducts(updatedProductsList);
//
//        repository.save(updatedBasket);
//
//        return updatedBasket;
//    }
//
//    public void deleteBasket(Integer id){
//        repository.deleteById(id);
//    }
//
//    public Basket addTo(Integer basketId, ProductDTO productDTO) {
//        Basket basket = repository.findById(basketId).get();
////        List<Product> products = basket.getProducts();
//
////        products.add(productService.getById(productDTO.getId()));
//
////        basket.setProducts(products);
//
//        repository.save(basket);
//
//        return basket;
//    }
//
//    public Basket create(BasketDTO1 basketDTO1) {
//        Basket basket = new Basket(
////                basketDTO1.getProductIds()
////                        .stream()
////                        .map(id -> {return productService.getById(id);})
////                        .collect(Collectors.toList())
//        );
//
//        return repository.save(basket);
//    }
}
