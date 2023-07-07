package com.practice.store.controller;

import com.practice.store.entity.ProductEntity;
import com.practice.store.service.implimentations.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts() { return productService.getAll(); }

    @GetMapping("/products/{productIdId:\\d+}")
    public ProductEntity getProductById(@PathVariable("productIdId") int id) {
        return productService.getById(id);
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity createProduct(@RequestBody ProductEntity request) {
        return productService.create(request);
    }

    @PutMapping("/products/{productIdId}")
    public ProductEntity updateProduct(@PathVariable("productIdId") int id, @RequestBody ProductEntity request) {
        return productService.update(id, request);
    }

    @DeleteMapping("/products/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("productId") int id) {
        productService.delete(id);
    }
}
