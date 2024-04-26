package com.example.Diplom.Dto;

import com.example.Diplom.Model.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String article;
    private String name;
    private Float price;
    private String image;
    private Set<Size> sizes = new HashSet<>();
    private Set<ColorDto> colors = new HashSet<>();
    private CategoryDto category;
    private Set<MaterialDto> materials = new HashSet<>();
    //private Set<ProductOrderDto> productOrders;
}
