package com.student;

import com.student.model.Address;
import com.student.model.Student;
import com.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentserviceApplication {

    @Autowired
    StudentRepo studentRepo;

    public static void main(String[] args) {
        SpringApplication.run(StudentserviceApplication.class, args);
    }

    @Bean
    ApplicationRunner runner() {

        return (ApplicationArguments applicationArguments) -> {

            var addStd1 = Address.builder()
                    .area("Rahmat Nager")
                    .zipCode(211013)
                    .houseNo("23").build();

            var addStd2 = Address.builder()
                    .area("M.M coloney")
                    .zipCode(841226)
                    .houseNo("24").build();

            var std1 = Student.builder()
                    .name("ramez")
                    .email("imramez@gmail.com")
                    .rollNo("1")
                    .address(addStd1)
                    .build();

            var std2 = Student.builder()
                    .name("Akhlaq")
                    .email("imakhlaq@gmail.com")
                    .rollNo("2")
                    .address(addStd2)
                    .build();

            studentRepo.saveAll(List.of(std2, std1));
        };
    }

}
