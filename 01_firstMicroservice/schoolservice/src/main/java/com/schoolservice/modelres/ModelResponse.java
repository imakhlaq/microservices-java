package com.schoolservice.modelres;

import com.schoolservice.model.Address;
import com.schoolservice.resmodel.StudentServiceRes;
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
    private StudentServiceRes students;
    
}
