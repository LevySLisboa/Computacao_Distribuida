package com.unifor.Arquiteturas.models.dtos;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @Id
    private Long id;
    private String name;
    private Double price;
    private String description;
}
