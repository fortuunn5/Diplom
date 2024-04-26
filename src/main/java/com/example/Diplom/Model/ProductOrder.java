package com.example.Diplom.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Size chosenSize;

    @ManyToOne(optional = false)
    @JoinColumn(name = "color_id", nullable = false)
    private Color chosenColor;

    public ProductOrder(Product product, Order order, Integer count, Size chosenSize, Color chosenColor) {
        this.count = count;
        this.product = product;
        this.order = order;
        this.chosenSize=chosenSize;
        this.chosenColor=chosenColor;
    }
}
