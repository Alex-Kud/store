package com.practice.store.service.implimentations;

import com.practice.store.dao.ProductDao;
import com.practice.store.entity.ProductEntity;
import com.practice.store.exception.NotFoundProductException;
import com.practice.store.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductDao productDao;

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
    public ProductEntity create(ProductEntity request) {
        ProductEntity product = getProductEntity(request);
        System.out.println(product.toString());
        return productDao.save(product);
    }

    @Override
    public ProductEntity update(int id, ProductEntity request) {
        if (!productDao.existsById(id)) {
            throw new NotFoundProductException(id);
        }
        ProductEntity product = getProductEntity(request);
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

    private ProductEntity getProductEntity(ProductEntity request) {
        ProductEntity product = new ProductEntity();
        product.setTitle(request.getTitle());
        product.setLength(request.getLength());
        product.setWidth(request.getWidth());
        product.setHeight(request.getHeight());
        product.setWeight(request.getWeight());
        product.setPrice(request.getPrice());

        return product;
    }
}
