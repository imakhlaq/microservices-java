package com.studentservice.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String rollNo;
    private String name;
    private String email;

    @Embedded
    private Address address ;


}


@Embeddable
class Address {
    
}