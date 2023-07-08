package com.practice.store.service.implimentations;

import com.practice.store.dao.ProductDao;
import com.practice.store.dto.ProductDto;
import com.practice.store.entity.ProductEntity;
import com.practice.store.exception.NotFoundProductException;
import com.practice.store.mapper.ProductMapper;
import com.practice.store.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductEntity> getAll() {
        return productDao.findAllByOrderByIdAsc();
    }

    @Override
    public ProductEntity getById(int id) {

        ProductEntity product = productDao.findById(id);
        if (product == null) {
            throw new NotFoundProductException(id);
        }
        return product;
    }

    @Override
    public ProductEntity create(ProductDto request) {
        ProductEntity product = productMapper.toEntity(request);

        return productDao.save(product);
    }

    @Override
    public ProductEntity update(int id, ProductDto request) {
        if (!productDao.existsById(id)) {
            throw new NotFoundProductException(id);
        }
        ProductEntity product = productMapper.toEntity(request);
        product.setId(id);

        return productDao.save(product);
    }

    @Override
    public void delete(int id) {
        if (!productDao.existsById(id)) {
            throw new NotFoundProductException(id);
        }

        ProductEntity product = productDao.findById(id);

        productDao.delete(product);
    }
}
