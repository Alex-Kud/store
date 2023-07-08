package com.practice.store.service.interfaces;

import com.practice.store.dto.BuyerDto;
import com.practice.store.entity.BuyerEntity;
import java.util.List;

public interface IBuyerService {

    List<BuyerEntity> getAll();

    BuyerEntity getById(int id);

    BuyerEntity create(BuyerDto request);

    BuyerEntity update(int id, BuyerDto request);

    void delete(int id);
}
