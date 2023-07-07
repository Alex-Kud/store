package com.practice.store.service.interfaces;

import com.practice.store.entity.ProductEntity;
import java.util.List;

public interface IProductService {

    List<ProductEntity> getAll();

    ProductEntity getById(int id);

    ProductEntity create(ProductEntity request);

    ProductEntity update(int id, ProductEntity request);

    void delete(int id);
}
