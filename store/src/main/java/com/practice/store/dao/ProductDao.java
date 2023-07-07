package com.practice.store.dao;

import com.practice.store.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDao extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findAllByOrderByIdAsc();
    ProductEntity findById(int id);
}
