package com.acciojob.student_api.service;

import com.acciojob.student_api.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsService {

    @Autowired
    StudentRepo studentRepo;

//    public DetailsService(){
//        this.studentRepo = new StudentRepo();
//    }


    public String getStudentNameById(int id){
        return studentRepo.get(id);
    }

}
