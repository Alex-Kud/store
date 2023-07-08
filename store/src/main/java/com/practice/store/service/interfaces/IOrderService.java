package com.practice.store.service.interfaces;

import com.practice.store.dto.OrderDto;
import com.practice.store.entity.OrderEntity;

public interface IOrderService {
    OrderEntity create(OrderDto request);
}
