package com.schoolservice.repo;

import com.schoolservice.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SchoolRepo extends JpaRepository<School, UUID> {
    
    Optional<School> findBySchoolNameEquals(String schoolName);
    
}
