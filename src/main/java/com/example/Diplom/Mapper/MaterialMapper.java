package com.example.Diplom.Mapper;

import com.example.Diplom.Dto.MaterialDto;
import com.example.Diplom.Model.Material;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MaterialMapper {
    public static Material map(MaterialDto materialDto) {
        Material material = Material.builder()
                .id(materialDto.getId())
                .name(materialDto.getName())
                .build();
        return material;
    }

    public static MaterialDto map(Material material) {
        MaterialDto materialDto = MaterialDto.builder()
                .id(material.getId())
                .name(material.getName())
                .build();
        return materialDto;
    }

    public static Set<Material> map(Set<MaterialDto> materialDtoSet) {
        Set<Material> materialSet = materialDtoSet.stream().map(MaterialMapper::map).collect(Collectors.toSet());
        return materialSet;
    }

    public static Set<MaterialDto> mapToDtoSet(Set<Material> materialSet) {
        Set<MaterialDto> materialDtoSet = materialSet.stream().map(MaterialMapper::map).collect(Collectors.toSet());
        return materialDtoSet;
    }
}
