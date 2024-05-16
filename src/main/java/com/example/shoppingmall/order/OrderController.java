package com.example.shoppingmall.order;

import com.example.shoppingmall.product.product.Product;
import com.example.shoppingmall.product.product.ProductService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class OrderController {

    OrderService orderService;
    ProductService productService;
    OrderDto orderDto;

    @PostMapping("/orders")
//    public void orderProduct(@RequestBody Order order) {
//    public void orderProduct(@RequestBody int productId, int count) {
    public void orderProduct(@RequestBody OrderDto orderDto){
//        orderService.orderProduct();
        Product orderedProduct = productService.findProduct(orderDto.productId);

        //DTO를 Entity로 바꾸기 (DTO -> Entity)
        Order requestOrder = new Order(orderedProduct,orderDto.counnt);
        orderService.orderProduct(requestOrder);

    }

    @GetMapping("/orders")
    public int getOrder()
    {
        System.out.println("1234");
        return 1;
    }
}