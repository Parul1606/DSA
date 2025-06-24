package com.acciojob.hms.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Hospital {
    int id;
    String name;
    String address;
    String email;
    Long phoneNumber;
    List<Doctor> doctors;
    List<Patient> patients;
}
