package com.example.Diplom.Service;

import com.example.Diplom.Model.Category;
import com.example.Diplom.Model.Product;
import com.example.Diplom.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    //TODO: ADVICE
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsByCategory(Category category) {
        return productRepository.findAllByCategory(category);
    }

    public List<Product> getAllProductsByFilter(String search) {
        return productRepository.findByNameContainingIgnoreCaseOrArticleContainingIgnoreCase(search, search);
    }

    //TODO: ADVICE
    public Product updateProduct(Product upProduct) {
        return productRepository.save(upProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
