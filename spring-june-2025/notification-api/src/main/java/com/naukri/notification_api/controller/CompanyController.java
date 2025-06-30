package com.naukri.notification_api.controller;


import com.naukri.notification_api.models.AppUser;
import com.naukri.notification_api.models.Company;
import com.naukri.notification_api.services.CompanyService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification/company")
public class CompanyController {

    CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PutMapping("/invite-recruiter/{token}")
    public void sendInvitatiionMailToRecruiter(@RequestBody AppUser recruiter, @PathVariable String token) throws MessagingException {
        // To send mail to the recruiter we require recruiter details also.
        // If you have seen your database-api recruiter is nothing but your object of AppUser model.
        // with the userType as recruiter.
        companyService.sendInvitationMailToRecruiter(recruiter, token);
    }

    @PutMapping("/accept-invitation")
    public void sendAcceptInvitationMailToAdmin(@RequestBody List<AppUser> mailDetails) throws MessagingException {
        AppUser recruiter = mailDetails.get(0);
        AppUser admin = mailDetails.get(1);
        companyService.sendAcceptNotificationMailToAdmin(recruiter, admin);
    }


}
