package com.schoolservice.resmodel;

import com.schoolservice.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentServiceRes {
    
    private UUID id;
    private String rollNo;
    private String name;
    private String email;
    private Address address;
}


