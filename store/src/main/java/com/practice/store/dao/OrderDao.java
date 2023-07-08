package com.practice.store.dao;

import com.practice.store.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends CrudRepository<OrderEntity, Integer> {
}
