package com.livel.userservice.user;

import com.livel.userservice.ModelRes;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    
    @Autowired
    UserService userService;
    
    @GetMapping("/user_info")
    @CircuitBreaker(name="productUserBreaker", fallbackMethod="getUserWithProductsFallback")
    //circuit breaker for this method. name is important it will be used in config
    //u have to add circulate breaker to every route handler that is communicating to other service.
    //fallback method will be called if product service does not respond
    // return from call back method should be same as main one
    
    //retry is same as circulate breaker => all rules from above
    @Retry(name="productUserRetry", fallbackMethod="getUserWithProductsFallback")
    
    //ratelimiter is same as circulate breaker => all rules from above
    @RateLimiter(name="productUserLimiter", fallbackMethod="getUserWithProductsFallback")
    ResponseEntity<ModelRes> getUserWithProducts() {
        
        return ResponseEntity.ok(userService.getUserWithProducts());
    }
    
    //when the request to product service is failed this fallback method will be called
    
    //u will have same arguments here as the main api method and an error object
    ResponseEntity<ModelRes> getUserWithProductsFallback(Exception e) {
        
        ModelRes modelRes = new ModelRes();
        modelRes.setName("KEKW");
        
        System.out.println("INSIDE THE FALL BACK");
        return ResponseEntity.ok(modelRes);
    }
    
    @GetMapping("/user_dp")
    @CircuitBreaker(name="idProductBreaker", fallbackMethod="getUserDPFallback")
    //retry is same as circulate breaker => all rules from above
    @Retry(name="idProductRetry", fallbackMethod="getUserDPFallback")
    
    //ratelimiter is same as circulate breaker => all rules from above
    @RateLimiter(name="idProductLimiter", fallbackMethod="getUserDPFallback")
    ResponseEntity<Object> getUserDP() {
        
        return ResponseEntity.ok(userService.getProductWithId(1));
    }
    
    ResponseEntity<Object> getUserDPFallback(Exception e) {
        
        return ResponseEntity.ok("KEKW SERVICE IS DOWN");
        
    }
    
}
