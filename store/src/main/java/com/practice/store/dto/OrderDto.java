package com.practice.store.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Integer buyerId;
    private Integer productId;
    private Integer quantity;

    public OrderDto(Integer buyerId, Integer productId, Integer quantity) {
        this.buyerId = buyerId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
