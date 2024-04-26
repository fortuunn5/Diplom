package com.example.Diplom.Dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColorDto {
    private Long id;
    private String name;
    private String HEXView;
    //private Set<ProductDto> products;
}
