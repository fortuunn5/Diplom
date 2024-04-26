package com.example.Diplom.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOrderDto {
    private Long id;
    private Integer count;
    private ProductDto product;
    private OrderDto order;
}
