package com.livel.productservice.products;

import com.livel.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @GetMapping("/all_products")
    ResponseEntity<List<Product>> getAllProduct() {
        
        System.out.println("Request Received");
        return ResponseEntity.ok(productService.getAllProducts());
    }
    
    @GetMapping("/product/{id}")
    ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
        
        return ResponseEntity.ok(productService.getProduct(id));
    }
}
