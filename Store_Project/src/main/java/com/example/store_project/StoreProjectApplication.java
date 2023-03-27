package com.example.store_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(/*exclude={DataSourceAutoConfiguration.class}*/)
public class StoreProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreProjectApplication.class, args);
    }

}
