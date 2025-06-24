package service;

import repository.StudentRepository;

public class RegistrationService {

    StudentRepository studentRepository;

    public RegistrationService(){
        this.studentRepository = new StudentRepository();
    }

    public void saveStudent(String name){
        int id = studentRepository.getTotalStudent() + 1;
        studentRepository.saveStudent(id, name);
    }
}
