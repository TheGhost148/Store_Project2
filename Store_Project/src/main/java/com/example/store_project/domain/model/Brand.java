package com.example.store_project.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Brand {
    @Id
    @SequenceGenerator(name = "brand_id_sequence_generator",
            sequenceName = "brand_id_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;

//    @OneToMany
//    private List<Product> products;

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
