package com.example.shoppingmall.order;

import com.example.shoppingmall.product.product.Product;
import com.example.shoppingmall.product.product.ProductRepository;
import com.example.shoppingmall.product.product.ProductService;
import lombok.AllArgsConstructor;
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
