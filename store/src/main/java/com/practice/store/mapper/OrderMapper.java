package com.practice.store.mapper;

import com.practice.store.dao.BuyerDao;
import com.practice.store.dao.ProductDao;
import com.practice.store.dto.OrderDto;
import com.practice.store.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { BuyerDao.class, ProductDao.class })
public interface OrderMapper {
    @Mapping(source = "buyerId", target = "buyer")
    @Mapping(source = "productId", target = "product")
    OrderEntity toEntity(OrderDto order);
}
