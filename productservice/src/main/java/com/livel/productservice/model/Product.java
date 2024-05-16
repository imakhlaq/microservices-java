package com.livel.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * represents a model Product
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {
    
    private UUID uuid;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    
}
