package com.practice.store.mapper;

import com.practice.store.dto.ProductDto;
import com.practice.store.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDto(ProductEntity product);
    ProductEntity toEntity(ProductDto product);
}
