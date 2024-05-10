package com.schoolservice.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;

import java.util.List;

@Configuration
public class StudentServiceLoadBalancerConfig {
    
    @Bean
    @Primary
    ServiceInstanceListSupplier serviceInstanceListSupplier() {
        
        return new StudentServiceInstanceListSuppler("student-service");
    }
}

class StudentServiceInstanceListSuppler implements ServiceInstanceListSupplier {
    
    private final String serviceId;
    
    StudentServiceInstanceListSuppler(String serviceId) {
        
        this.serviceId = serviceId;
    }
    
    @Override
    public String getServiceId() {
        
        return this.serviceId;
    }
    
    @Override
    public Flux<List<ServiceInstance>> get() {
        
        return Flux.just(List.of(
            
            //all the list of uri to server instance
            new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 57842, false),
            new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 57841, false)
        ));
    }
}