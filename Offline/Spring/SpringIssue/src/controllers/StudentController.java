package controllers;

import service.DetailsService;
import service.RegistrationService;

import java.util.Scanner;

public class StudentController {

    DetailsService detailsService;
    RegistrationService registrationService;
    Scanner scn;

    public StudentController(){
        this.detailsService = new DetailsService();
        this.registrationService = new RegistrationService();
        this.scn = new Scanner(System.in);
    }

    public void startProgram(){
        while(true){
            System.out.println("What you want to do ? \nIf want to see student details Enter 1 Or register Student enter 2");
            int input = scn.nextInt();
            if(input == 1){
                // Bring sudent details
                System.out.println("Enter student id: ");
                int id = scn.nextInt();
                String name = detailsService.getStudentDetailsById(id);
                System.out.println(name);
                System.out.println("Student details fetched successfully");
            }else{
                // create student
                System.out.println("Please enter name of student you wan to save !!");
                String name = scn.next();
                // Save student
                registrationService.saveStudent(name);
                System.out.println("Student saved successfully !!");

            }
        }
    }
}
