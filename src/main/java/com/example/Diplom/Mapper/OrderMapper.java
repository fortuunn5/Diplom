package com.example.Diplom.Mapper;

import com.example.Diplom.Dto.ChosenPropertyDto;
import com.example.Diplom.Dto.OrderDto;
import com.example.Diplom.Dto.ProductDto;
import com.example.Diplom.Dto.ProductOrderDto;
import com.example.Diplom.Model.Order;
import com.example.Diplom.Model.ProductOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderMapper {
    public static Order map(OrderDto orderDto) {
        Order order = Order.builder()
                .id(orderDto.getId())
                .totalPrice(orderDto.getTotalPrice())
                .address(orderDto.getAddress())
                .createDate(orderDto.getCreateDate())
                //TODO: MAP USER
                //.user()
                .build();

        Map<ProductDto, ChosenPropertyDto> pc = orderDto.getProductProperty();
        Set<ProductOrder> productOrderSet = pc.entrySet()
                .stream()
                .map(x -> new ProductOrder(ProductMapper.map(
                        x.getKey()),
                        order,
                        x.getValue().getCount(),
                        x.getValue().getChosenSize(),
                        ColorMapper.map(x.getValue().getChosenColor())))
                .collect(Collectors.toSet());

        return order;
    }

    public static OrderDto map(Order order) {
        OrderDto orderDto = OrderDto.builder()
                .id(order.getId())
                .totalPrice(order.getTotalPrice())
                .address(order.getAddress())
                .createDate(order.getCreateDate())
                //TODO: MAP USER
                //.user()
                .build();
        /*Map<ProductDto, Integer> productDtoCountMap = order.getProductOrders().stream()
                .collect(Collectors.toMap(x->
                        ProductMapper.map(x.getProduct()),
                        ProductOrder::getCount
                ));
        orderDto.setProductCount(productDtoCountMap);*/


        Map<ProductDto, ChosenPropertyDto> productWithProperty = order.getProductOrders().stream()
                .collect(Collectors.toMap(x->
                                ProductMapper.map(x.getProduct()),
                        y-> new ChosenPropertyDto(y.getCount(), y.getChosenSize(), ColorMapper.map(y.getChosenColor()))
                ));

        return orderDto;
    }

    public static Set<Order> map(Set<OrderDto> orderDtoSet) {
        Set<Order> orderSet = orderDtoSet.stream().map(OrderMapper::map).collect(Collectors.toSet());
        return orderSet;
    }

    public static Set<OrderDto> mapToDtoSet(Set<Order> orderSet) {
        Set<OrderDto> orderDtoSet = orderSet.stream().map(OrderMapper::map).collect(Collectors.toSet());
        return orderDtoSet;
    }
}
