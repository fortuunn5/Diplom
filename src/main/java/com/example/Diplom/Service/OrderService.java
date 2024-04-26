package com.example.Diplom.Service;

import com.example.Diplom.Model.Order;
import com.example.Diplom.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    }

    //TODO: ADVICE
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //TODO: ADVICE
    public Order updateOrder(Order upOrder) {
        return orderRepository.save(upOrder);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
