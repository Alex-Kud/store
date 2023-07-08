package com.practice.store.controller;

import com.practice.store.dto.OrderDto;
import com.practice.store.entity.OrderEntity;
import com.practice.store.service.implimentations.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderEntity createProduct(@RequestBody OrderDto request) {
        return orderService.create(request);
    }
}
