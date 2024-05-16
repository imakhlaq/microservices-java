package com.livel.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients  //======> to enable netflix Foreign client( used to make http req )
@EnableDiscoveryClient  //======= to register it a eureka client but not needed
public class ProductserviceApplication {
    
    public static void main(String[] args) {
        
        SpringApplication.run(ProductserviceApplication.class, args);
    }
    
}
