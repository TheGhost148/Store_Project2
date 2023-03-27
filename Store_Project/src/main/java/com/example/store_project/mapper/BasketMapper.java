package com.example.store_project.mapper;

import com.example.store_project.domain.model.Basket;
import com.example.store_project.dto.BasketGetDTO;
import com.example.store_project.repository.BasketRepository;
import com.example.store_project.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasketMapper {
    @Autowired
    private BasketService service;

    public BasketGetDTO get() {
        return new BasketGetDTO(service.get().getProductBatches());
    }
}
