package com.example.codewithmosh.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Category category;
}
