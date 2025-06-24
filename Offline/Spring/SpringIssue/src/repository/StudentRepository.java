package repository;

import java.util.HashMap;

public class StudentRepository {
    // StudentRepository is a class which is used to store student details in the database.
    // More over it is having methods to save and get the data.
    HashMap<Integer, String> studentDB;

    public StudentRepository(){
        this.studentDB = new HashMap<>();
    }

    public void saveStudent(int id, String name){
        studentDB.put(id, name);
    }

    public String getStudentBId(int id){
        String name = studentDB.get(id);
        return name;
    }

    public int getTotalStudent(){
        return studentDB.size();
    }
}
