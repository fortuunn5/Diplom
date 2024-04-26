package com.example.Diplom.Service;

import com.example.Diplom.Model.Material;
import com.example.Diplom.Repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialService {
    private final MaterialRepository materialRepository;

    public Material createMaterial(Material newMaterial) {
        return materialRepository.save(newMaterial);
    }

    //TODO: ADVICE
    public Material getMaterial(Long id) {
        return materialRepository.findById(id).orElseThrow();
    }

    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    //TODO: ADVICE
    public Material updateMaterial(Material upMaterial) {
        return materialRepository.save(upMaterial);
    }

    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }
}
