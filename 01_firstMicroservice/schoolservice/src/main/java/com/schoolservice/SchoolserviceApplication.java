package com.schoolservice;

import com.schoolservice.model.Address;
import com.schoolservice.model.School;
import com.schoolservice.repo.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class SchoolserviceApplication {
    
    @Autowired
    SchoolRepo schoolRepo;
    
    @Value("${base.url}")
    String baseURL;
    
    public static void main(String[] args) {
        
        SpringApplication.run(SchoolserviceApplication.class, args);
    }
    
    @Bean
    public RestClient restClient() {
        
        return RestClient.builder()
            .baseUrl("http://localhost:8081")
            .build();
    }
    
    @Bean
    public CommandLineRunner commandLineRunner() {
        
        return (data) -> {
            
            var address = Address.builder()
                .area("rahmatNager").zipCode(211016)
                .buildingNo("22").build();
            var address2 = Address.builder()
                .area("gtbNager").zipCode(211011)
                .buildingNo("28").build();
            
            var school = School.builder()
                .schoolName("sauzab").address(address).build();
            var school2 = School.builder()
                .schoolName("unity").address(address2).build();
            
            schoolRepo.saveAll(List.of(school, school2));
        };
    }
}
