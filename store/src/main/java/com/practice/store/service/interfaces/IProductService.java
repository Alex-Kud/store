package com.practice.store.service.interfaces;

import com.practice.store.dto.ProductDto;
import com.practice.store.entity.ProductEntity;
import java.util.List;

public interface IProductService {

    List<ProductEntity> getAll();

    ProductEntity getById(int id);

    ProductEntity create(ProductDto request);

    ProductEntity update(int id, ProductDto request);

    void delete(int id);
}
