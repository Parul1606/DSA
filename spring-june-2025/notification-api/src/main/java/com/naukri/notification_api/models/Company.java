package com.naukri.notification_api.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Company {

    UUID id;

    String companyName;

    String email;

    String websiteLink;

    String linkedinLink;

    int companySize;

    String industry;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
