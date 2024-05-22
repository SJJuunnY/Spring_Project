package com.example.shoppingmall.order;

import com.example.shoppingmall.product.ProductRepository;
import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
@Getter
@Setter
public class OrderDto {
    ProductRepository productRepository;
    OrderRepository orderRepository;

//    Product product;
//    int count;
    int productId;
    int counnt;
}
