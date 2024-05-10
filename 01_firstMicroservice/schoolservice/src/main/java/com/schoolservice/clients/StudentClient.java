package com.schoolservice.clients;

import com.schoolservice.config.StudentServiceLoadBalancerConfig;
import com.schoolservice.resmodel.StudentServiceRes;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//now using this client make request
//, url="http://localhost:8081" don't use url in FeignClient because it will be determined by loadbalancer
@FeignClient(name="studentService", path="/api")
//client side loadBalancer
@LoadBalancerClient(name="student-service", configuration=StudentServiceLoadBalancerConfig.class)
public interface StudentClient {
    
    @GetMapping("/student/{id}")
    ResponseEntity<StudentServiceRes> getStudent(@PathVariable("id") String id);
}
