package com.unifor.Arquiteturas.controllers;

import com.unifor.Arquiteturas.models.Product;
import com.unifor.Arquiteturas.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServices service;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(service.createProduct(product));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Product> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
