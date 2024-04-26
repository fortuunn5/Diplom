package com.example.Diplom.Mapper;

import com.example.Diplom.Dto.ProductDto;
import com.example.Diplom.Model.Product;

import java.util.List;

public class ProductMapper {
    public static Product map(ProductDto productDto) {
        Product product = Product.builder()
                .id(productDto.getId())
                .article(productDto.getArticle())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .image(productDto.getImage())
                .sizes(productDto.getSizes())
                .category(CategoryMapper.map(productDto.getCategory()))
                .colors(ColorMapper.map(productDto.getColors()))
                .materials(MaterialMapper.map(productDto.getMaterials()))
                .build();
        return product;
    }

    public static ProductDto map(Product product) {
        ProductDto productDto = ProductDto.builder()
                .id(product.getId())
                .article(product.getArticle())
                .name(product.getName())
                .price(product.getPrice())
                .image(product.getImage())
                .sizes(product.getSizes())
                .category(CategoryMapper.map(product.getCategory()))
                .colors(ColorMapper.mapToDtoSet(product.getColors()))
                .materials(MaterialMapper.mapToDtoSet(product.getMaterials()))
                .build();
        return productDto;
    }

    public static List<Product> map(List<ProductDto> productDtoList) {
        List<Product> productList = productDtoList.stream().map(ProductMapper::map).toList();
        return productList;
    }

    public static List<ProductDto> mapToDtoList(List<Product> productList) {
        List<ProductDto> productDtoList = productList.stream().map(ProductMapper::map).toList();
        return productDtoList;
    }
}
