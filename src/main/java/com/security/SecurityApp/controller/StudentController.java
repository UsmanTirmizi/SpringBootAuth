package com.security.SecurityApp.controller;



import com.security.SecurityApp.model.Student;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.config.annotation.web.CsrfDsl;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private  List<Student> stu= new ArrayList<>(List.of(
            new Student(1,"Usman", 90),
            new Student(2,"Ali", 80),
            new Student(3,"Ahmed", 70),
            new Student(4,"Asad", 60),
            new Student(5,"Kashif", 50)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return stu;
    }
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        stu.add(student);
        return student;
    }
}

