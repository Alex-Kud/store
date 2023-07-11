package com.practice.store.controller;

import com.practice.store.dto.OrderDto;
import com.practice.store.entity.OrderEntity;
import com.practice.store.service.implimentations.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static java.lang.System.*;
import static java.lang.System.in;

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

    @RequestMapping(path = "/get_report", method = RequestMethod.GET)
    public ResponseEntity<Resource> download() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=Report.xlsx");

        ByteArrayResource resource = orderService.export();
        //ByteArrayInputStream in = orderService.export();
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(resource);
                //.body(new InputStreamResource(in));
    }
}
