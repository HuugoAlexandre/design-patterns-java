package com.example.ecommerce.controller;

import com.example.ecommerce.catalog.*;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {
    private final CatalogService service;
    public CatalogController(CatalogService service){ this.service = service; }

    @GetMapping("/products") public Collection<SimpleProduct> products(){ return service.list(); }

    @PostMapping("/products")
    public SimpleProduct create(@RequestBody SimpleProduct p){ return service.create(p); }

    @PostMapping("/products/{id}/restock")
    public String restock(@PathVariable String id, @RequestParam int qty){ service.restock(id, qty); return "restocked"; }
}
