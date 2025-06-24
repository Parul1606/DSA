package com.acciojob.hms.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Doctor {
    int id;
    String name;
    String specialization;
    String degree;
    String email;
    Long phoneNumber;
}
