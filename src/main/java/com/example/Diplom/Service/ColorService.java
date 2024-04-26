package com.example.Diplom.Service;

import com.example.Diplom.Model.Color;
import com.example.Diplom.Repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorService {
    private final ColorRepository colorRepository;

    public Color createColor(Color newColor) {
        return colorRepository.save(newColor);
    }

    //TODO:ADVICE
    public Color getColor(Long id) {
        return colorRepository.findById(id).orElseThrow();
    }

    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }


    //TODO:ADVICE
    public Color updateColor(Color upColor) {
        return colorRepository.save(upColor);
    }

    public void deleteColor(Long id) {
        colorRepository.deleteById(id);
    }
}
