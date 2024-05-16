package com.livel.userservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class User {
    
    private UUID id;
    private String name;
    
    List<Product> products;
    
}
