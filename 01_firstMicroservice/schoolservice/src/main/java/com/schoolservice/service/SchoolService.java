package com.schoolservice.service;

import com.schoolservice.modelres.ModelResponse;
import com.schoolservice.repo.SchoolRepo;
import com.schoolservice.resmodel.StudentServiceRes;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SchoolService {
    
    @Autowired
    SchoolRepo schoolRepo;
    
    @Autowired
    RestClient restClient;
    
    public Object getStudentAndSchool(String rollno, String schoolID) {
        
        var studentServiceRes = restClient.get().uri("/api/student/1").retrieve().toEntity(StudentServiceRes.class);
        
        var school = schoolRepo.findBySchoolNameEquals("sauzab").get();
        var modelRes = new ModelResponse();
        
        BeanUtils.copyProperties(school, modelRes);
        
        return modelRes;
    }
    
}
