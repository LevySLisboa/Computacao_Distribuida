package com.unifor.Arquiteturas.repositories;

import com.unifor.Arquiteturas.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
