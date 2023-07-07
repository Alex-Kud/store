package com.practice.store.service.interfaces;

import com.practice.store.entity.BuyerEntity;
import java.util.List;

public interface IBuyerService {

    List<BuyerEntity> getAll();

    BuyerEntity getById(int id);

    BuyerEntity create(BuyerEntity request);

    BuyerEntity update(int id, BuyerEntity request);

    void delete(int id);
}
