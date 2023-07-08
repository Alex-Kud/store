package com.practice.store.mapper;

import com.practice.store.dto.BuyerDto;
import com.practice.store.entity.BuyerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BuyerMapper {
    BuyerMapper INSTANCE = Mappers.getMapper(BuyerMapper.class);

    BuyerDto toDto(BuyerEntity buyer);
    BuyerEntity toEntity(BuyerDto buyer);
}
