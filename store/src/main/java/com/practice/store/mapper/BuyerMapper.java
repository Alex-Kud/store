package com.practice.store.mapper;

import com.practice.store.dto.BuyerDto;
import com.practice.store.entity.BuyerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuyerMapper {
    BuyerDto toDto(BuyerEntity buyer);
    BuyerEntity toEntity(BuyerDto buyer);
}
