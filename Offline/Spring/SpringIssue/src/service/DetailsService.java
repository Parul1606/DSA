package service;

import repository.StudentRepository;

public class DetailsService {

    StudentRepository studentRepository;

    public DetailsService(){
        this.studentRepository = new StudentRepository();
    }

    public String getStudentDetailsById(int id){
        String name = studentRepository.getStudentBId(id);
        return name;
    }
}
