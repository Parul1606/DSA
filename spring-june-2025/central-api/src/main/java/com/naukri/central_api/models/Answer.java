package com.naukri.central_api.models;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class Answer {

    UUID id;
    String answer;

    Questions question;
}
