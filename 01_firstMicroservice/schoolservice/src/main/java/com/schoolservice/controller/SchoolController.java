package com.schoolservice.controller;

import com.schoolservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api")
public class SchoolController {
    
    @Autowired
    SchoolService schoolService;
    
    @GetMapping("/{school_id}/{student_roll_no}")
    ResponseEntity<?> getSchoolAndTopperStudent(@PathVariable("school_id") String schoolId,
                                                @PathVariable("student_roll_no") String studentId) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchMethodException {
        
        return ResponseEntity.ok().body(schoolService.getStudentAndSchool(schoolId, studentId));
    }
}
