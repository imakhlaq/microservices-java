package com.student.service;

import com.student.model.Student;
import com.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;


    public Student getStudentInfo(String rollNo) {
        return studentRepo.findByRollNoEquals(rollNo).orElseThrow(() -> new IllegalArgumentException("not available"));
    }
}
