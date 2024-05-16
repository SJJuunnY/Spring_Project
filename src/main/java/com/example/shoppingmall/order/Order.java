package com.example.shoppingmall.order;

import com.example.shoppingmall.product.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Order {
    String orderId;

    public Order(Product orderedProduct, int count) {
        this.product = orderedProduct;
        this.count = count;
    }

    Product product; // PK역할 하는 친구 - int productId여야 했음
    int count;
    //DB column : Orders orders_id or id "통일성" DB에서 Order예약어로 사용되어 있어서 사용할수 없다
}
