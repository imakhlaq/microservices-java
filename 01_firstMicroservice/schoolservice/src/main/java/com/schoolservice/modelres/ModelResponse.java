package com.schoolservice.modelres;

import com.schoolservice.service.SchoolService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelResponse {
    
    private UUID id;
    private String schoolName;
    private Address address;
    private SchoolService students;
    
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Address {
    
    private String houseNo;
    private String area;
    private Integer zipCode;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class StudentServiceRes {
    
    private UUID id;
    private String rollNo;
    private String name;
    private String email;
    private Address address;
}