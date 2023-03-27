package com.example.store_project.controller;

import com.example.store_project.domain.model.*;
import com.example.store_project.dto.*;
import com.example.store_project.mapper.BasketMapper;
import com.example.store_project.mapper.ProductMapper;
import com.example.store_project.mapper.SubCategoryMapper;
import com.example.store_project.other.CustomResponse;
import com.example.store_project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rest")
public class MainController {
    @Autowired
    private ProductService productService;

    @Autowired
    private BasketService basketService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SubCategoryMapper subCategoryMapper;
    @Autowired
    private BasketMapper basketMapper;

//    @PutMapping("/product/{id}")
//    public Product updateProduct(@RequestBody Product product,@PathVariable Integer id){
//        return productService.update(id, product);
//    }
//
//    @DeleteMapping("/product/{id}")
//    public void deleteProduct(@PathVariable Integer id) {
//        productService.delete(id);
//    }
//
//
//
//
//
//    @GetMapping("/basket/{id}")
//    public Basket getBasketById(@PathVariable Integer id) {
//        return basketService.getById(id);
//    }
//
//    @GetMapping("/baskets")
//    public List<Basket> getAllBaskets() {
//        return basketService.getAll();
//    }
//
//    @PostMapping("/basket")
//    public Basket createBasket(@RequestBody BasketDTO1 basketDTO1){
//        return basketService.create(basketDTO1);
//    }
//
//    @PostMapping("/basket/{id}")
//    public Basket addToBasket(@RequestBody ProductDTO productDTO, @PathVariable Integer id){
//        return basketService.addTo(id,productDTO);
//    }
//
//    @PutMapping("/basket/{id}")
//    public Basket updateBasket(@RequestBody BasketDTO1 basketDTO1, @PathVariable Integer id){
//        return basketService.update(id, basketDTO1);
//    }








    @GetMapping("/product/{id}")
    public FullProductDTO getProduct(@PathVariable Integer id) throws SQLException {
        return productMapper.getFullProductDTO(id);
    }

    @GetMapping("/products")
    public List<ProductGetDTO> getAllProducts(@RequestParam(required = false) Optional<String> name,
                                              @RequestParam(required = false) Optional<Integer> brandId,
                                              @RequestParam(required = false) Optional<BigDecimal> priceFrom,
                                              @RequestParam(required = false) Optional<BigDecimal> priceUntil,
                                              @RequestParam(required = false) Optional<BigDecimal> avgRating,
                                              @RequestParam(required = false) Optional<Integer> categoryId,
                                              @RequestParam(required = false) Optional<Integer> subCategoryId,
                                              @RequestParam(required = false) Optional<Integer> pageNumber,
                                              @RequestParam(required = false) Optional<Integer> pageSize
                                              ) throws SQLException {
        return productMapper.
                getAllProductGetDTOs(
                        name,
                        brandId,
                        priceFrom,
                        priceUntil,
                        avgRating,
                        categoryId,
                        subCategoryId,
                        pageNumber,
                        pageSize);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping ("/subCategories")
    public List<SubCategoryGetDTO> getAllSubCategories(@RequestParam(required = false) Optional<Integer> categoryId) throws SQLException {
        return subCategoryMapper.getAll(categoryId);
    }

    @GetMapping ("/brands")
    public List<Brand> getAllBrands(){
        return brandService.getAll();
    }

    @PostMapping ("/product/{productId}/postReview")
    public CustomResponse postReview(@PathVariable Integer productId,
                                     @RequestBody ReviewPostDTO reviewPostDTO) {
        reviewService.save
                (new Review(reviewPostDTO.getUserName(),
                        productId,
                        reviewPostDTO.getRating(),
                        reviewPostDTO.getComment()));

        return new CustomResponse("Status - postReview","ExceptionText");
    }

    @GetMapping ("/product/{productId}/getReviews")
    public List<Review> getAllReviews(@PathVariable Integer productId){
        return reviewService.getAllByProductId(productId);
    }

    @PostMapping ("/addToBasket")
    public CustomResponse addToBasket(@RequestBody BasketPostDTO basketPostDTO){
        basketService.addToBasket(basketPostDTO);

        return new CustomResponse("Status - addToBasket","ExceptionText");
    }

    @PutMapping ("/basket/{id}/update")
    public CustomResponse updateProductBatch(@PathVariable Integer id,
                                     @RequestParam(required = true) Integer quantity){
        basketService.updateProductBatch(id, quantity);

        return new CustomResponse("Status - updateProductBatch","ExceptionText");
    }

    @GetMapping ("/getBasket")
    public BasketGetDTO getBasket(){
        return basketMapper.get();
    }

    @DeleteMapping ("/basket/{id}/remove")
    public CustomResponse removeProductBatch(@PathVariable Integer id){
        basketService.removeProductBatch(id);

        return new CustomResponse("Status - removeProductBatch","ExceptionText");
    }

    @PutMapping ("/product/pic/{productId}/upload")
    public CustomResponse uploadProductPic(@PathVariable Integer productId){
        productService.updateProductPic(productId);

        return new CustomResponse("Status - uploadProductPic","ExceptionText");
    }

}

