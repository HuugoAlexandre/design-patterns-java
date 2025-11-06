package com.example.ecommerce.controller;

import com.example.ecommerce.integration.IntegrationFacade;
import com.example.ecommerce.payment.PaymentInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/integration")
public class IntegrationController {
    private final IntegrationFacade facade;
    public IntegrationController(IntegrationFacade facade){ this.facade = facade; }

    @PostMapping("/pay")
    public String pay(@RequestParam String gateway, @RequestBody PaymentInfo info){
        boolean ok = facade.processPayment(gateway, info);
        return ok ? "OK via " + gateway : "FAILED";
    }
}
