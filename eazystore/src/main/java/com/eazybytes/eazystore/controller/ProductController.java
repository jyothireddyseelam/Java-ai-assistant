package com.eazybytes.eazystore.controller;

import com.eazybytes.eazystore.entity.Product;
import com.eazybytes.eazystore.service.IProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        System.out.println("Testing Code Changes 1");
        return productService.getAllProducts();

    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {

        return productService.getProductById(id);
    }
}