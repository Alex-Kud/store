package com.practice.store.dao;

import com.practice.store.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findAllByOrderByIdAsc();
    ProductEntity findById(int id);
}
