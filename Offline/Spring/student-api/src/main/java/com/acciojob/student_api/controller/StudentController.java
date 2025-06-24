package com.acciojob.student_api.controller;

import com.acciojob.student_api.service.DetailsService;
import com.acciojob.student_api.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    DetailsService detailsService;

//    public StudentController(){
//        this.detailsService = new DetailsService();
//        this.registrationService = new RegistrationService();
//    }


    @PostMapping("/save/{name}")
    public String saveStudent(@PathVariable String name){
        // This method will save the student name in the database
        registrationService.saveStudent(name);
        return "Student saved successfully !!";
    }

    @GetMapping("/get/{id}")
    public String getStudent(@PathVariable int id){
        // This method will get the student name from the database by id
        return detailsService.getStudentNameById(id);
    }

}
