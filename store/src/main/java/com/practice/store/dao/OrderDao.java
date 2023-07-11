package com.practice.store.dao;

import com.practice.store.entity.BuyerEntity;
import com.practice.store.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends CrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findAllByOrderByIdAsc();
}
