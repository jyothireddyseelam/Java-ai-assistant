package com.eazybytes.eazystore.controller;


import com.eazybytes.eazystore.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductServiceController {

    @GetMapping
    public List<Product> getProducts() {
        return List.of(
                new Product(1L, "Laptop", 1200),
                new Product(2L, "Phone", 800)
        );
    }
}
