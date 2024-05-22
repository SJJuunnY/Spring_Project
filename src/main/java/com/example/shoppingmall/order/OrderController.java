package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import com.example.shoppingmall.product.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class OrderController {

    OrderService orderService;
    ProductService productService;

    @PostMapping("/orders")
//    public void orderProduct(@RequestBody Order order) {
//    public void orderProduct(@RequestBody int productId, int count) {
    public void orderProduct(@RequestBody @Valid OrderDto orderDto){
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