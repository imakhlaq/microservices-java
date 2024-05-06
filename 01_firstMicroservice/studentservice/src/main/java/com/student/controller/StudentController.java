package com.student.controller;

import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/student")
public class StudentController {
    
    @Autowired
    StudentService studentService;
    
    @GetMapping("/{roll_number}")
    ResponseEntity<?> getStudentInfo(@PathVariable("roll_number") String rollNo) {
        
        return ResponseEntity.ok(studentService.getStudentInfo(rollNo));
    }
}
