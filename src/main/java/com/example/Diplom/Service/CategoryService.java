package com.example.Diplom.Service;

import com.example.Diplom.Model.Category;
import com.example.Diplom.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category createCategory(Category newCategory) {
        return categoryRepository.save(newCategory);
    }

    //TODO: ADVICE
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public List<Category> getAllCategories() {
        List<Category> sortedList = categoryRepository.findAll().stream()
                .sorted(Comparator.comparingLong(Category::getId))
                .collect(Collectors.toList());
        return sortedList;
    }

    //TODO:ADVICE
    public Category updateCategory(Category upCategory) {
        return categoryRepository.save(upCategory);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
