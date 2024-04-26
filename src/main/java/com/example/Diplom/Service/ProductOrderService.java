package com.example.Diplom.Service;

import com.example.Diplom.Model.ProductOrder;
import com.example.Diplom.Repository.ProductOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductOrderService {
    //TODO: ???

    private final ProductOrderRepository productOrderRepository;

    public ProductOrder createProductOrder(ProductOrder newProductOrder) {
        return productOrderRepository.save(newProductOrder);
    }

    //TODO: ADVICE
    public ProductOrder getProductOrder(Long id) {
        return productOrderRepository.findById(id).orElseThrow();
    }

    public List<ProductOrder> getAllProductOrders() {
        return productOrderRepository.findAll();
    }

    //TODO: ADVICE
    public ProductOrder updateProductOrder(ProductOrder upProductOrder) {
        return productOrderRepository.save(upProductOrder);
    }

    public void deleteProductOrder(Long id) {
        productOrderRepository.deleteById(id);
    }
}
