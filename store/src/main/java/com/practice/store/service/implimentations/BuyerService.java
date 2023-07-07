package com.practice.store.service.implimentations;

import com.practice.store.dao.BuyerDao;
import com.practice.store.entity.BuyerEntity;
import com.practice.store.exception.NotFoundBuyerException;
import com.practice.store.service.interfaces.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService implements IBuyerService {

    @Autowired
    private BuyerDao buyerDao;

    @Override
    public List<BuyerEntity> getAll() {
        return buyerDao.findAllByOrderByIdAsc();
    }

    @Override
    public BuyerEntity getById(int id) {

        BuyerEntity buyer = buyerDao.findById(id);
        if (buyer == null) {
            throw new NotFoundBuyerException(id);
        }
        return buyer;
    }

    @Override
    public BuyerEntity create(BuyerEntity request) {
        BuyerEntity buyer = getBuyerEntity(request);

        return buyerDao.save(buyer);
    }

    @Override
    public BuyerEntity update(int id, BuyerEntity request) {
        if (!buyerDao.existsById(id)) {
            throw new NotFoundBuyerException(id);
        }
        BuyerEntity buyer = getBuyerEntity(request);
        buyer.setId(id);

        return buyerDao.save(buyer);
    }

    @Override
    public void delete(int id) {
        if (!buyerDao.existsById(id)) {
            throw new NotFoundBuyerException(id);
        }

        BuyerEntity buyer = buyerDao.findById(id);

        buyerDao.delete(buyer);
    }

    private BuyerEntity getBuyerEntity(BuyerEntity request) {
        BuyerEntity buyer = new BuyerEntity();
        buyer.setSurname(request.getSurname());
        buyer.setFirstname(request.getFirstname());
        buyer.setLastname(request.getLastname());
        buyer.setPhone(request.getPhone());
        buyer.setAddress(request.getAddress());

        return buyer;
    }
}
