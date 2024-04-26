package com.example.Diplom.Repository;

import com.example.Diplom.Model.Category;
import com.example.Diplom.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("from Product pr where ?1 in (pr.getCategories()) ")
//    List<Product> getAllProductsByCategory(Category category);

    List<Product> findAllByCategory(Category category);

    List<Product> findByNameContainingIgnoreCaseOrArticleContainingIgnoreCase(String text, String search);
}
