package com.livel.userservice;

import com.livel.userservice.pojo.Product;
import lombok.Data;

import java.util.List;

@Data
public class ModelRes {
    
    private String name;
    
    private List<Product> products;
}
