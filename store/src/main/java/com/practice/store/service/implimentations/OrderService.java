package com.practice.store.service.implimentations;

import com.practice.store.dao.BuyerDao;
import com.practice.store.dao.OrderDao;
import com.practice.store.dao.ProductDao;
import com.practice.store.dto.OrderDto;
import com.practice.store.entity.OrderEntity;
import com.practice.store.mapper.OrderMapper;
import com.practice.store.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class OrderService implements IOrderService {
    // Инициализация логера
    private static final Logger log = Logger.getLogger(String.valueOf(OrderService.class));

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private BuyerDao buyerDao;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderEntity create(OrderDto request) {
        if(productDao.findById(request.getProductId()).isPresent() &&
                buyerDao.findById(request.getBuyerId()).isPresent()) {
            OrderEntity order = orderMapper.toEntity(request);
            order.setDate(LocalDate.now());
            log.log(Level.INFO, "Заказ успешно создан");
            return orderDao.save(order);
        }
        else {
            log.log(Level.SEVERE, "Ошибка при создании заказа");
            return null;
        }
    }
}
