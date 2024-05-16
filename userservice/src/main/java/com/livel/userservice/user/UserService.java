package com.livel.userservice.user;

import com.livel.userservice.ModelRes;
import com.livel.userservice.clints.ProductClient;
import com.livel.userservice.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Service
public class UserService {
    
    @Autowired
    ProductClient productClient;
    @Autowired
    private RestClient.Builder restClientBuilder;
    
    ModelRes getUserWithProducts() {
        
        var user = User.builder().id(UUID.randomUUID())
            .name("Akhlaq").build();
        
        //making request using feign client
        var addressRes = productClient.getAllProducts().getBody();
        
        user.setProducts(addressRes);
        
        // you have to hide the sensitive data by returning a response model
        var modelUserRes = new ModelRes();
        BeanUtils.copyProperties(user, modelUserRes);
        
        return modelUserRes;
    }
}
