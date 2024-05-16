package com.example.shoppingmall.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class OrderRepository {
    Map<Integer, Order> orders = new HashMap<>();

    private int id=0;

    public Order createOrder(Order order){
//        log.info("order.getItemName() = {}",order.getItemName());
        log.info("order.getCount() = {}",order.getCount());
        orders.put(id++, order);
        System.out.println(
                "/orders : repository - " + orders.get(id));
        return orders.get(id);
    }
}
