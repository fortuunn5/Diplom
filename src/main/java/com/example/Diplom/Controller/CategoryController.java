package com.example.Diplom.Controller;

import com.example.Diplom.Dto.CategoryDto;
import com.example.Diplom.Mapper.CategoryMapper;
import com.example.Diplom.Model.Category;
import com.example.Diplom.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto newCategory) {
        return new ResponseEntity<>(CategoryMapper.map(categoryService.createCategory(CategoryMapper.map(newCategory))), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(CategoryMapper.map(categoryService.getCategory(id)));
    }

    @GetMapping("/all")
    //TODO: v ordere update proverit na syshestvovanie
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(CategoryMapper.mapToDtoSet(new HashSet<Category>(categoryService.getAllCategories())).stream().toList());
    }

    @PutMapping
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto upCategory) {
        return ResponseEntity.ok(CategoryMapper.map(categoryService.updateCategory(CategoryMapper.map(upCategory))));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCategory(@PathVariable(name = "id") Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
