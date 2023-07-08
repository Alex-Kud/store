package com.practice.store.mapper;

import com.practice.store.dto.ProductDto;
import com.practice.store.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(ProductEntity product);
    ProductEntity toEntity(ProductDto product);
}
