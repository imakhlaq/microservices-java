package com.livel.userservice.clints;

import com.livel.userservice.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//name should be same as the service name that you want to hit for client side load balancing.
//and it is also used to get the service ip and port to make request
@FeignClient(name="productservice", path="/productservice/api")
public interface ProductClient {
    
    //request uri is constructed by eureka client and feign client
    //              |=> will be replaced by ip and port
    //                              |=>context path defined in feign client
    //                                              |=>end point you want to hit
    //http//:productservice/productservice/api/all_products
    
    @GetMapping("/all_products")
    ResponseEntity<List<Product>> getAllProducts();
    
    @GetMapping("/product/{id}")
    ResponseEntity<Product> getProduct(@PathVariable("id") int id);
}
