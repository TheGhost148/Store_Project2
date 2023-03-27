package com.example.store_project.mapper;

import com.example.store_project.domain.model.SubCategory;
import com.example.store_project.dto.FullProductDTO;
import com.example.store_project.dto.SubCategoryGetDTO;
import com.example.store_project.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SubCategoryMapper {
    @Autowired
    private SubCategoryService subCategoryService;

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

    public List<SubCategoryGetDTO> getAll(Optional<Integer> categoryId)
//            throws SQLException
    {
//        List<SubCategoryGetDTO> subCategoryGetDTOs = new ArrayList<>();
//
//        String sql = "SELECT * FROM sub_category sc " +
//                "WHERE " +
//                "(? IS NULL OR sc.category_id = ?)";
//
//        Connection dbConnection = this.getConnection();
//
//        PreparedStatement statement = dbConnection.prepareStatement(sql);
//
//        if(categoryId.isPresent()) {
//            statement.setInt(1,categoryId.get());
//            statement.setInt(2,categoryId.get());
//        } else {
//            statement.setNull(1,java.sql.Types.INTEGER);
//            statement.setNull(2,java.sql.Types.INTEGER);
//        }
//
//        ResultSet resultSet = statement.executeQuery();
//
//        while (resultSet.next()) {
//            SubCategoryGetDTO subCategoryGetDTO =
//                    new SubCategoryGetDTO();
//
//            subCategoryGetDTO.setId(resultSet.getInt("id"));
//            subCategoryGetDTO.setName(resultSet.getString("name"));
//            subCategoryGetDTO.setCategoryId(resultSet.getInt("category_id"));
//            subCategoryGetDTO.setOrderId(resultSet.getInt("order_id"));
//
//            subCategoryGetDTOs.add(subCategoryGetDTO);
//        }
//
//        return subCategoryGetDTOs;

        return subCategoryService.getAll(categoryId)
                .stream()
                .map(subCategory -> {
                    return new SubCategoryGetDTO(subCategory);
                })
                .collect(Collectors.toList());
    }
}
