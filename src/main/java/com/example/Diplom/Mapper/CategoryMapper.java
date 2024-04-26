package com.example.Diplom.Mapper;

import com.example.Diplom.Dto.CategoryDto;
import com.example.Diplom.Model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryMapper {
    public static Category map(CategoryDto categoryDto) {
        Category category = Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .build();
        return category;
    }

    public static CategoryDto map(Category category) {
        CategoryDto categoryDto = CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
        return categoryDto;
    }

    public static Set<Category> map(Set<CategoryDto> categoryDtoSet) {
        Set<Category> categorySet = categoryDtoSet.stream().map(CategoryMapper::map).collect(Collectors.toSet());
        return categorySet;
    }

    public static Set<CategoryDto> mapToDtoSet(Set<Category> categorySet) {
        Set<CategoryDto> categoryDtoSet = categorySet.stream().map(CategoryMapper::map).collect(Collectors.toSet());
        return categoryDtoSet;
    }
}
