package com.example.demo.controller;

import com.example.demo.facade.OrderFacade;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class OrderController {

    private final OrderFacade orderFacade;

    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @GetMapping("/place-order")
    public String placeOrder() {
        Customer customer = new Customer("C001", "Hugo");
        List<Product> products = List.of(
                new Product("P001", "Mouse", 120.0),
                new Product("P002", "Teclado", 200.0)
        );

        return orderFacade.placeOrder(customer, products);
    }
}
