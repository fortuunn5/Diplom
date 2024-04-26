package com.example.Diplom.Mapper;

import com.example.Diplom.Dto.CategoryDto;
import com.example.Diplom.Dto.ColorDto;
import com.example.Diplom.Model.Category;
import com.example.Diplom.Model.Color;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ColorMapper {
    public static Color map(ColorDto colorDto) {
        Color color = Color.builder()
                .id(colorDto.getId())
                .name(colorDto.getName())
                .HEXView(colorDto.getHEXView())
                .build();
        return color;
    }

    public static ColorDto map(Color color) {
        ColorDto colorDto = ColorDto.builder()
                .id(color.getId())
                .name(color.getName())
                .HEXView(color.getHEXView())
                .build();
        return colorDto;
    }

    public static Set<Color> map(Set<ColorDto> colorDtoSet) {
        Set<Color> colorSet = colorDtoSet.stream().map(ColorMapper::map).collect(Collectors.toSet());
        return colorSet;
    }

    public static Set<ColorDto> mapToDtoSet(Set<Color> colorSet) {
        Set<ColorDto> colorDtoSet = colorSet.stream().map(ColorMapper::map).collect(Collectors.toSet());
        return colorDtoSet;
    }
}
