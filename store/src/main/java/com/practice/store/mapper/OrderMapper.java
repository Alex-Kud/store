package com.practice.store.mapper;

import com.practice.store.dao.BuyerDao;
import com.practice.store.dao.ProductDao;
import com.practice.store.dto.OrderDto;
import com.practice.store.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { BuyerDao.class, ProductDao.class })
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    /*@Mapping(source = "buyer", target = "buyerId")
    @Mapping(source = "product", target = "productId")
    OrderDto toDto(OrderEntity order);*/

    @Mapping(source = "buyerId", target = "buyer")
    @Mapping(source = "productId", target = "product")
    OrderEntity toEntity(OrderDto order);
}
