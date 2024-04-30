package com.schoolservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
    
    @GetMapping("/{school_id}/{student_roll_no}")
    ResponseEntity<?> getSchoolAndTopperStudent(@PathVariable("school_id") String schoolId,
                                                @PathVariable("student_roll_no") String studentId) {
        
    }
}
