package com.livel.userservice.user;

import com.livel.userservice.ModelRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    
    @Autowired
    UserService userService;
    
    @GetMapping("/user_info")
    ResponseEntity<ModelRes> getUserWithProducts() {
        
        return ResponseEntity.ok(userService.getUserWithProducts());
    }
}
