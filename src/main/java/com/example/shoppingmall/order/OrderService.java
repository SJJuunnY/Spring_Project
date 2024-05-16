package com.example.shoppingmall.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class OrderService {
    OrderRepository orderRepository;

    public void orderProduct(Order order) {
        log.info("orderId = {} ", order.orderId);
        log.info("order = {} ", order.getProduct())

        orderRepository.createOrder(order);
    }
}
