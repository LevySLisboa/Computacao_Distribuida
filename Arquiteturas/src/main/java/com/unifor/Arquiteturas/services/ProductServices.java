package com.unifor.Arquiteturas.services;

import com.unifor.Arquiteturas.models.Product;
import com.unifor.Arquiteturas.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository repository;

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
