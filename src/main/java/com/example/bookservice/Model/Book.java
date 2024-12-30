package com.example.bookservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
}
