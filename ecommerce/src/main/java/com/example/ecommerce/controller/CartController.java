package com.example.ecommerce.controller;

import com.example.ecommerce.cart.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/shipping")
    public double shipping(@RequestBody CartRequest request, @RequestParam String strategy) {
        Cart cart = new Cart();
        // converte DTO para objetos reais do Composite
        for (CartRequest.ItemDTO dto : request.getItems()) {
            cart.add(new CartItem(dto.getName(), dto.getQuantity(), dto.getUnitPrice()));
        }
        return cartService.calcShipping(cart, strategy);
    }
}
