package com.acciojob.student_api.service;

import com.acciojob.student_api.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    StudentRepo studentRepo;


    public void saveStudent(String name){
        int id = studentRepo.getTotalStudents() + 1;
        studentRepo.save(id, name);
    }

}
