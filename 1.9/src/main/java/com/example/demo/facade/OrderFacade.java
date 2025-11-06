package com.example.demo.facade;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.service.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class OrderFacade {

    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderService orderService;
    private final PaymentService paymentService;

    public OrderFacade(CustomerService customerService, ProductService productService,
                       OrderService orderService, PaymentService paymentService) {
        this.customerService = customerService;
        this.productService = productService;
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    public String placeOrder(Customer customer, List<Product> products) {
        if (!customerService.validateCustomer(customer))
            return "Falha: cliente inválido.";

        if (!productService.checkAvailability(products))
            return "Falha: produtos indisponíveis.";

        double total = products.stream().mapToDouble(Product::getPrice).sum();
        String orderId = orderService.createOrder(customer, products);
        boolean success = paymentService.processPayment(orderId, total);

        if (success)
            return "Pedido realizado com sucesso! ID: " + orderId + " | Valor total: R$ " + total;
        else
            return "Falha no pagamento para o pedido " + orderId;
    }
}
