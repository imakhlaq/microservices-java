package com.schoolservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class School {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    private String schoolName;
    @Embedded
    private Address address;
}
