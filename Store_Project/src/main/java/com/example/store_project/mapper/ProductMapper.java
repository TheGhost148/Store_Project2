package com.example.store_project.mapper;

import com.example.store_project.domain.model.Product;
import com.example.store_project.dto.FullProductDTO;
import com.example.store_project.dto.ProductGetDTO;
import com.example.store_project.domain.model.Brand;
import com.example.store_project.domain.model.Category;
import com.example.store_project.domain.model.SubCategory;
import com.example.store_project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    @Autowired
    private BrandService brandService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ProductService productService;

//    public ProductMapper(){
//
//    }
//
//    @Autowired
//    public ProductMapper(BrandService brandService, CategoryService categoryService, SubCategoryService subCategoryService) {
//        this.brandService = brandService;
//        this.categoryService = categoryService;
//        this.subCategoryService = subCategoryService;
//    }

//    private Connection getConnection() {
//        Connection connection = null;
//
//        try {
//            // Register the PostgreSQL JDBC driver
//            Class.forName("org.postgresql.Driver");
//
//            // Create a connection to the database
//            String url = "jdbc:postgresql://localhost:5433/store_project_db";
//            String username = "postgres";
//            String password = "";
//            connection = DriverManager.getConnection(url, username, password);
//
//            // Do something with the connection...
//        } catch (ClassNotFoundException e) {
//            System.out.println("PostgreSQL JDBC driver not found");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("Connection failed");
//            e.printStackTrace();
//        }
//
//        return connection;
//    }
    public FullProductDTO getFullProductDTO(Integer id)
            //throws SQLException
                                {
//        String sql = "SELECT * FROM product LEFT JOIN product_reviews pr on product.id = pr.product_id WHERE product.id = ?";
//        Connection dbConnection = this.getConnection();
//
//        PreparedStatement statement = dbConnection.prepareStatement(sql);
//        statement.setInt(1, id);
//
//        ResultSet resultSet = statement.executeQuery();

//        if (resultSet.next()) {
//            FullProductDTO fullProductDTO
//                    = new FullProductDTO();
//
//            fullProductDTO.setId(resultSet.getInt("id"));
//            fullProductDTO.setName
//                    (resultSet.getString("name"));
//            fullProductDTO.setPic(resultSet.getString("pic"));
//            fullProductDTO.setCategory
//                    (this.categoryService.getById(resultSet.getInt("category_id")).getName());
//            fullProductDTO.setCategoryId
//                    (resultSet.getInt("category_id"));
//            fullProductDTO.setSubCategory
//                    (this.subCategoryService.getById(resultSet.getInt("sub_category_id")).getName());
//            fullProductDTO.setSubCategoryId
//                    (resultSet.getInt("sub_category_id"));
//            fullProductDTO.setBaseDescription
//                    (resultSet.getString("base_description"));
//            fullProductDTO.setDescription
//                    (resultSet.getString("description"));
//            fullProductDTO.setReviews
//                    (this.reviewService.getAllByProductId(resultSet.getInt("id")));
//            fullProductDTO.setReviewsAvg
//                    (resultSet.getBigDecimal("reviews_avg"));
//            fullProductDTO.setReviewsCount
//                    (resultSet.getInt("reviews_count"));
//            fullProductDTO.setPrice
//                    (resultSet.getBigDecimal("price"));
//            fullProductDTO.setBrandId
//                    (brandService.getById(resultSet.getInt("brand_id")).getId());
//            fullProductDTO.setBrandName
//                    (brandService.getById(resultSet.getInt("brand_id")).getName());
//
//            return fullProductDTO;
//        } else {
//            return null;
//        }

        return new FullProductDTO(productService.getById(id));
    }

    public List<ProductGetDTO> getAllProductGetDTOs(
            Optional<String> name,
            Optional<Integer> brandId,
            Optional<BigDecimal> priceFrom,
            Optional<BigDecimal> priceUntil,
            Optional<BigDecimal> avgRating,
            Optional<Integer> categoryId,
            Optional<Integer> subCategoryId,
            Optional<Integer> pageNumber,
            Optional<Integer> pageSize
    ) throws SQLException {
        if(pageNumber.isEmpty() && pageSize.isEmpty()) {
            return productService.getAll(
                    name.orElse(null),
                    brandId.orElse(null),
                    priceFrom.orElse(null),
                    priceUntil.orElse(null),
                    avgRating.orElse(null),
                    categoryId.orElse(null),
                    subCategoryId.orElse(null),
                    null)
                    .stream()
                    .map(product -> {
                        return new ProductGetDTO(product);
                    })
                    .collect(Collectors.toList());
        } else {
            return productService.getAll(name.orElse(null),
                            brandId.orElse(null),
                            priceFrom.orElse(null),
                            priceUntil.orElse(null),
                            avgRating.orElse(null),
                            categoryId.orElse(null),
                            subCategoryId.orElse(null),
                            PageRequest.of(
                                    (pageNumber.get() - 1) * pageSize.get(),
                                            pageSize.get()))
                    .stream()
                    .map(product -> {
                        return new ProductGetDTO(product);
                    })
                    .collect(Collectors.toList());
        }
//        String sqlWithoutPageNumberAndPageSize = "SELECT * FROM product p " +
//                "WHERE " +
//                "(? IS NULL OR p.name = ?) " +
//                "AND (? IS NULL OR p.brand_id = ?) " +
//                "AND (? IS NULL OR p.price > ?) " +
//                "AND (? IS NULL OR p.price < ?) " +
//                "AND (? IS NULL OR p.reviews_avg = ?) " +
//                "AND (? IS NULL OR p.category_id = ?) " +
//                "AND (? IS NULL OR p.sub_category_id = ?);";
//
//        String sqlWithPageNumberAndPageSize = "SELECT * FROM product p " +
//                "WHERE " +
//                "(? IS NULL OR p.name = ?) " +
//                "AND (? IS NULL OR p.brand_id = ?) " +
//                "AND (? IS NULL OR p.price > ?) " +
//                "AND (? IS NULL OR p.price < ?) " +
//                "AND (? IS NULL OR p.reviews_avg = ?) " +
//                "AND (? IS NULL OR p.category_id = ?) " +
//                "AND (? IS NULL OR p.sub_category_id = ?) " +
//                "OFFSET ? ROWS " +
//                "FETCH NEXT ? ROWS ONLY;";
//
//
//
//        Connection dbConnection = this.getConnection();
//
////        PreparedStatement statementWithPageNumberAndPageSize = dbConnection.prepareStatement(sqlWithPageNumberAndPageSize);
////        PreparedStatement statementWithoutPageNumberAndPageSize = dbConnection.prepareStatement(sqlWithoutPageNumberAndPageSize);
//
//        PreparedStatement preparedStatement = createPreparedStatement
//                            (
//                                    dbConnection,
//                                    pageNumber.isEmpty() && pageSize.isEmpty() ?
//                                            sqlWithoutPageNumberAndPageSize : sqlWithPageNumberAndPageSize,
//                                    name,
//                                    brandId,
//                                    priceFrom,
//                                    priceUntil,
//                                    avgRating,
//                                    categoryId,
//                                    subCategoryId,
//                                    pageNumber,
//                                    pageSize
//                            );
////            if(name.isPresent()) {
////                statementWithPageNumberAndPageSize.setString(1, name.get());
////                statementWithPageNumberAndPageSize.setString(2, name.get());
////            } else {
////                statementWithPageNumberAndPageSize.setString(1, null);
////                statementWithPageNumberAndPageSize.setString(2, null);
////            }
////
////            if(brandId.isPresent()) {
////                statementWithPageNumberAndPageSize.setInt(3, brandId.get());
////                statementWithPageNumberAndPageSize.setInt(4, brandId.get());
////            } else {
////                statementWithPageNumberAndPageSize.setNull(3, java.sql.Types.INTEGER);
////                statementWithPageNumberAndPageSize.setNull(4, java.sql.Types.INTEGER);
////            }
////
////            if(priceFrom.isPresent()) {
////                statementWithPageNumberAndPageSize.setDouble(5, priceFrom.get());
////                statementWithPageNumberAndPageSize.setDouble(6, priceFrom.get());
////            } else {
////                statementWithPageNumberAndPageSize.setNull(5, java.sql.Types.DOUBLE);
////                statementWithPageNumberAndPageSize.setNull(6, java.sql.Types.DOUBLE);
////            }
////
////            if(priceUntil.isPresent()) {
////                statementWithPageNumberAndPageSize.setDouble(7, priceUntil.get());
////                statementWithPageNumberAndPageSize.setDouble(8, priceUntil.get());
////            } else {
////                statementWithPageNumberAndPageSize.setNull(7, java.sql.Types.DOUBLE);
////                statementWithPageNumberAndPageSize.setNull(8, java.sql.Types.DOUBLE);
////            }
////
////            if(avgRating.isPresent()) {
////                statementWithPageNumberAndPageSize.setDouble(9, avgRating.get());
////                statementWithPageNumberAndPageSize.setDouble(10, avgRating.get());
////            } else {
////                statementWithPageNumberAndPageSize.setNull(9, java.sql.Types.DOUBLE);
////                statementWithPageNumberAndPageSize.setNull(10, java.sql.Types.DOUBLE);
////            }
////
////            if(categoryId.isPresent()) {
////                statementWithPageNumberAndPageSize.setInt(11, categoryId.get());
////                statementWithPageNumberAndPageSize.setInt(12, categoryId.get());
////            } else {
////                statementWithPageNumberAndPageSize.setNull(11, java.sql.Types.INTEGER);
////                statementWithPageNumberAndPageSize.setNull(12, java.sql.Types.INTEGER);
////            }
////
////            if(subCategoryId.isPresent()) {
////                statementWithPageNumberAndPageSize.setInt(13, subCategoryId.get());
////                statementWithPageNumberAndPageSize.setInt(14, subCategoryId.get());
////            } else {
////                statementWithPageNumberAndPageSize.setNull(13, java.sql.Types.INTEGER);
////                statementWithPageNumberAndPageSize.setNull(14, java.sql.Types.INTEGER);
////            }
////
////            if(pageNumber.isPresent() && pageSize.isPresent()) {
////                statementWithPageNumberAndPageSize.setInt(15, (pageNumber.get() - 1) * pageSize.get());
////                statementWithPageNumberAndPageSize.setInt(16, pageSize.get());
////            } else {
////                statementWithPageNumberAndPageSize.setNull(15, java.sql.Types.INTEGER);
////                statementWithPageNumberAndPageSize.setNull(16, java.sql.Types.INTEGER);
////            }
//
////            statementWithPageNumberAndPageSize.setString(1, name);
////            statementWithPageNumberAndPageSize.setInt(2, brandId);
////            statementWithPageNumberAndPageSize.setDouble(3, priceFrom);
////            statementWithPageNumberAndPageSize.setDouble(4, priceUntil);
////            statementWithPageNumberAndPageSize.setDouble(5, avgRating);
////            statementWithPageNumberAndPageSize.setInt(6, categoryId);
////            statementWithPageNumberAndPageSize.setInt(7, subCategoryId);
////            statementWithPageNumberAndPageSize.setInt(8, ((pageNumber - 1) * pageSize));
////            statementWithPageNumberAndPageSize.setInt(9, pageSize);
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//
//        List<ProductGetDTO> productGetDTOs = new ArrayList<>();
//
//        while (resultSet.next()) {
//            ProductGetDTO productGetDTO = new ProductGetDTO();
//
//            productGetDTO.setId
//                    (resultSet.getInt("id"));
//            productGetDTO.setName
//                    (resultSet.getString("name"));
//            productGetDTO.setPic
//                    (resultSet.getString("pic"));
//            productGetDTO.setPrice
//                    (resultSet.getBigDecimal("price"));
//            productGetDTO.setBrandId
//                    (resultSet.getInt("brand_id"));
//            productGetDTO.setCategoryId
//                    (resultSet.getInt("category_id"));
//            productGetDTO.setSubCategoryId
//                    (resultSet.getInt("sub_category_id"));
//            productGetDTO.setReviewsCount
//                    (resultSet.getInt("reviews_count"));
//            productGetDTO.setReviewsAvg
//                    (resultSet.getBigDecimal("reviews_avg"));
//
//            productGetDTOs.add(productGetDTO);
//        }
//
//        return productGetDTOs;
    }

//    private PreparedStatement createPreparedStatement (
//            Connection dbConnection,
//            String sql,
//            Optional<String> name,
//            Optional<Integer> brandId,
//            Optional<Double> priceFrom,
//            Optional<Double> priceUntil,
//            Optional<Double> avgRating,
//            Optional<Integer> categoryId,
//            Optional<Integer> subCategoryId,
//            Optional<Integer> pageNumber,
//            Optional<Integer> pageSize
//    ) throws SQLException {
//        PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
//
//        if(name.isPresent()) {
////            Logger.getAnonymousLogger().info("name.isPresent()");
//            preparedStatement.setString(1, name.get());
////            Logger.getAnonymousLogger().info(name.get());
////            Logger.getAnonymousLogger().info(sql);
//            preparedStatement.setString(2, name.get());
//        } else {
//            Logger.getAnonymousLogger().info("name.isEmpty()");
//            preparedStatement.setNull(1, java.sql.Types.VARCHAR);
//            preparedStatement.setNull(2, java.sql.Types.VARCHAR);
//        }
//
//        if(brandId.isPresent()) {
//            preparedStatement.setInt(3, brandId.get());
//            preparedStatement.setInt(4, brandId.get());
//        } else {
//            preparedStatement.setNull(3, java.sql.Types.INTEGER);
//            preparedStatement.setNull(4, java.sql.Types.INTEGER);
//        }
//
//        if(priceFrom.isPresent()) {
//            preparedStatement.setDouble(5, priceFrom.get());
//            preparedStatement.setDouble(6, priceFrom.get());
//        } else {
//            preparedStatement.setNull(5, java.sql.Types.DOUBLE);
//            preparedStatement.setNull(6, java.sql.Types.DOUBLE);
//        }
//
//        if(priceUntil.isPresent()) {
//            preparedStatement.setDouble(7, priceUntil.get());
//            preparedStatement.setDouble(8, priceUntil.get());
//        } else {
//            preparedStatement.setNull(7, java.sql.Types.DOUBLE);
//            preparedStatement.setNull(8, java.sql.Types.DOUBLE);
//        }
//
//        if(avgRating.isPresent()) {
//            preparedStatement.setDouble(9, avgRating.get());
//            preparedStatement.setDouble(10, avgRating.get());
//        } else {
//            preparedStatement.setNull(9, java.sql.Types.DOUBLE);
//            preparedStatement.setNull(10, java.sql.Types.DOUBLE);
//        }
//
//        if(categoryId.isPresent()) {
//            preparedStatement.setInt(11, categoryId.get());
//            preparedStatement.setInt(12, categoryId.get());
//        } else {
//            preparedStatement.setNull(11, java.sql.Types.INTEGER);
//            preparedStatement.setNull(12, java.sql.Types.INTEGER);
//        }
//
//        if(subCategoryId.isPresent()) {
//            preparedStatement.setInt(13, subCategoryId.get());
//            preparedStatement.setInt(14, subCategoryId.get());
//        } else {
//            preparedStatement.setNull(13, java.sql.Types.INTEGER);
//            preparedStatement.setNull(14, java.sql.Types.INTEGER);
//        }
//
//        if(pageNumber.isPresent() && pageSize.isPresent()) {
//            preparedStatement.setInt(15, (pageNumber.get() - 1) * pageSize.get());
//            preparedStatement.setInt(16, pageSize.get());
//        }
////        else {
////            preparedStatement.setNull(15, java.sql.Types.INTEGER);
////            preparedStatement.setNull(16, java.sql.Types.INTEGER);
////        }
//
//        return preparedStatement;
//    }
}
