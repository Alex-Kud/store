package com.practice.store.service.interfaces;

import com.practice.store.dto.OrderDto;
import com.practice.store.entity.OrderEntity;
import org.springframework.core.io.ByteArrayResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public interface IOrderService {
    OrderEntity create(OrderDto request);

    ByteArrayResource export() throws IOException;
}
