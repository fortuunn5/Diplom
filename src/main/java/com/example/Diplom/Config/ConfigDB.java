package com.example.Diplom.Config;

import com.example.Diplom.Model.Category;
import com.example.Diplom.Model.Color;
import com.example.Diplom.Model.Product;
import com.example.Diplom.Model.Size;
import com.example.Diplom.Service.CategoryService;
import com.example.Diplom.Service.ColorService;
import com.example.Diplom.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class ConfigDB implements ApplicationRunner {
    private final ProductService productService;
    private final ColorService colorService;
    private final CategoryService categoryService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initProduct();
    }

    public void initProduct() {
        Color yellow = Color.builder()
                .name("yellow")
                .HEXView("#eaff00")
                .build();
        Color red = Color.builder()
                .name("red")
                .HEXView("#e34f22")
                .build();
        Color green = Color.builder()
                .name("green")
                .HEXView("#2A8310")
                .build();
        Color white = Color.builder()
                .name("white")
                .HEXView("#ffffff")
                .build();
        Color black = Color.builder()
                .name("black")
                .HEXView("#000000")
                .build();

        colorService.createColor(yellow);
        colorService.createColor(red);
        colorService.createColor(green);
        colorService.createColor(white);
        colorService.createColor(black);


        Category odezda = Category.builder()
                .name("Одежда")
                .build();
        Category aksesyari = Category.builder()
                .name("Аксессуары")
                .build();
        Category obyv = Category.builder()
                .name("Обувь")
                .build();
        categoryService.createCategory(odezda);
        categoryService.createCategory(aksesyari);
        categoryService.createCategory(obyv);



        Product p1 = Product.builder()
                //.id(1L)
                .name("футболка")
                .article("123")
                .price(1000F)
                .sizes(Set.of(Size.S, Size.M))
                .image("D:\\Учеба\\диплом\\Diplom\\images\\футболка.jpg")
                .colors(Set.of(yellow, red, white))
                .category(odezda)
                .build();
        Product p2 = Product.builder()
                //.id(2L)
                .name("Джинсы")
                .article("321")
                .price(3000F)
                .sizes(Set.of(Size.M))
                .image("D:\\Учеба\\диплом\\Diplom\\images\\джинсы.jpg")
                .colors(Set.of(green, black, white))
                .category(obyv)
                .build();
        productService.createProduct(p1);
        productService.createProduct(p2);
    }
}
