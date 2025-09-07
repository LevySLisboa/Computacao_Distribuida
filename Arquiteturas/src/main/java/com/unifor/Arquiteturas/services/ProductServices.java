package com.unifor.Arquiteturas.services;

import com.unifor.Arquiteturas.models.Product;
import com.unifor.Arquiteturas.models.dtos.ProductDTO;
import com.unifor.Arquiteturas.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository repository;

    public ProductDTO createProduct(ProductDTO obj) {
        Product product = new Product(obj.getId(), obj.getName(), obj.getPrice(), obj.getDescription());
        repository.save(product);
        return obj;
    }

    public List<ProductDTO> findAll() {
        List<Product> list = repository.findAll();
        List<ProductDTO> dtos = list.stream().map(x -> new ProductDTO(x.getId(), x.getName(), x.getPrice(), x.getDescription())).toList();
        return dtos;
    }

    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).orElseThrow();
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getDescription());
    }
}
