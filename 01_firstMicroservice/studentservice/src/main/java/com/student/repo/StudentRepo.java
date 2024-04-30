package com.student.repo;

import com.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepo extends JpaRepository<Student, UUID> {

    Optional<Student> findByRollNoEquals(String rollNo);
}
