package com.livel.productservice.products;

import com.livel.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    
    Product prod1 = Product.builder().uuid(UUID.randomUUID())
        .name("Honey Water").description("Water From mecca")
        .createdAt(LocalDateTime.of(2001, 10, 3, 2, 23, 4))
        .build();
    
    Product prod2 = Product.builder().uuid(UUID.randomUUID())
        .name("Ajwa").description("Date from mecca")
        .createdAt(LocalDateTime.of(1005, 10, 3, 2, 23, 4))
        .build();
    
    List<Product> getAllProducts() {
        
        return List.of(prod1, prod2);
    }
    
    Product getProduct(int id) {
        
        return prod1;
    }
    
}
