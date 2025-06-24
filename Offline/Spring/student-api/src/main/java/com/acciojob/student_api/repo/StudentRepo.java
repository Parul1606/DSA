package com.acciojob.student_api.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StudentRepo {

    @Autowired
    HashMap<Integer, String> studentDb;


    public void save(int id, String name){
        studentDb.put(id, name);
    }

    public String get(int id){
        return studentDb.get(id);
    }

    public int getTotalStudents(){
        return studentDb.size();
    }
}
