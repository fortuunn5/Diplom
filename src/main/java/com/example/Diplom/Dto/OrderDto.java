package com.example.Diplom.Dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private Float totalPrice;
    private String address;
    //private UserDto user;
    //TODO: COUNT BYTE??
    private Map<ProductDto, ChosenPropertyDto> productProperty;
    private LocalDate createDate;
    //private Set<ProductOrderDto> productOrders;
}
