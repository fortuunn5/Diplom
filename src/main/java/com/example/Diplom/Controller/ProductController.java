package com.example.Diplom.Controller;

import com.example.Diplom.Dto.CategoryDto;
import com.example.Diplom.Dto.ProductDto;
import com.example.Diplom.Mapper.CategoryMapper;
import com.example.Diplom.Mapper.ProductMapper;
import com.example.Diplom.Model.Category;
import com.example.Diplom.Service.CategoryService;
import com.example.Diplom.Service.ProductService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto newProduct) {
        return new ResponseEntity<ProductDto>(ProductMapper.map(productService.createProduct(ProductMapper.map(newProduct))), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(ProductMapper.map(productService.getProduct(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(name = "categoryId", required = false) Long categoryId) {
        if(categoryId!=null) {
            Category category = categoryService.getCategory(categoryId);
            return ResponseEntity.ok(ProductMapper.mapToDtoList(productService.getAllProductsByCategory(category)));
        }
        else {
            return ResponseEntity.ok(ProductMapper.mapToDtoList(productService.getAllProducts()));
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProductDto>> getProductsFilter(@RequestParam(name = "search", required = false) String search) {
        if(StringUtils.isBlank(search)) {
            return ResponseEntity.ok(ProductMapper.mapToDtoList(productService.getAllProducts()));
        }
        else {
            return ResponseEntity.ok(ProductMapper.mapToDtoList(productService.getAllProductsByFilter(search)));
        }
    }

    /*@GetMapping("/category")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@RequestBody CategoryDto category) {
        return ResponseEntity.ok(ProductMapper.mapToDtoList(productService.getAllProductsByCategory(CategoryMapper.map(category))));
    }*/

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto upProduct) {
        return ResponseEntity.ok(ProductMapper.map(productService.updateProduct(ProductMapper.map(upProduct))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
