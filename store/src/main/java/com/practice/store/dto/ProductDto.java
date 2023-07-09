package com.practice.store.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String title;
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer weight;
    private Float price;
}
