package com.practice.store.dao;

import com.practice.store.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<OrderEntity, Integer> {
}
