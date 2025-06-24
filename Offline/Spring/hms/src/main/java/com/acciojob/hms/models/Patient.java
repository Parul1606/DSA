package com.acciojob.hms.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {
    int id;
    String name;
    String gender;
    int age;
    String disease;
}
