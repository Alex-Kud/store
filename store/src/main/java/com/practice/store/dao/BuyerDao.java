package com.practice.store.dao;

import com.practice.store.entity.BuyerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuyerDao extends CrudRepository<BuyerEntity, Integer> {
    List<BuyerEntity> findAllByOrderByIdAsc();
    BuyerEntity findById(int id);
}
