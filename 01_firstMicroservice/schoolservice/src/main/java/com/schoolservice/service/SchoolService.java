package com.schoolservice.service;

import com.schoolservice.clients.StudentClient;
import com.schoolservice.modelres.ModelResponse;
import com.schoolservice.repo.SchoolRepo;
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
    
    @Autowired
    StudentClient studentClient;
    
    public Object getStudentAndSchool(String rollno, String schoolID) {
        
        //using restClient / restTemplate to make http call
      /*  var studentServiceRes = restClient.get().uri("/api/student/1")
            .retrieve().toEntity(StudentServiceRes.class).getBody();*/
        
        var studentServiceRes = studentClient.getStudent("1").getBody();
        
        var school = schoolRepo.findBySchoolNameEquals("sauzab").get();
        System.out.println(school);
        
        var modelRes = new ModelResponse();
        
        BeanUtils.copyProperties(school, modelRes);
        
   /*     //using reflection creating instance of Student response
        modelRes.setStudents((StudentServiceRes) Class.forName("com.schoolservice.resmodel.StudentServiceRes").getConstructor().newInstance());*/
        
        modelRes.setStudents(studentServiceRes);
        
        //copy property to the model response
        BeanUtils.copyProperties(studentServiceRes, modelRes.getStudents());
        
        System.out.println(modelRes);
        
        return modelRes;
    }
    
}
