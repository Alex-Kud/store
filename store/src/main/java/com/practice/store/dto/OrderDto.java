package com.practice.store.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Integer buyerId;
    private Integer productId;
    private Integer quantity;
}
