package com.naukri.central_api.service;

import com.naukri.central_api.connectors.DatabaseApiConnector;
import com.naukri.central_api.dto.JobSeekerRegistrationDto;
import com.naukri.central_api.models.AppUser;
import com.naukri.central_api.models.Skill;
import com.naukri.central_api.service.SkillService;
import com.naukri.central_api.utility.AuthUtility;
import com.naukri.central_api.utility.MappingUtility;
import io.jsonwebtoken.Jwts;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    SkillService skillService;
    MappingUtility mappingUtility;
    DatabaseApiConnector dbApiConnector;

    @Value("${secret.password}")
    String secretPassword;

    @Autowired
    public UserService(SkillService skillService,
                       MappingUtility mappingUtility,
                       DatabaseApiConnector dbApiConnector){
        this.skillService = skillService;
        this.mappingUtility = mappingUtility;
        this.dbApiConnector = dbApiConnector;
    }

    public AppUser registerJobSeeker(JobSeekerRegistrationDto jobSeekerDto){
        // FrontEnd -> Controller -> Service
        // central api needs to use database api to save jobseekerr
        // From our central api we need to think something such that we will be able to hit
        // database-api user registration endpoint.

        // 1. We need to map data of jobSeekerDto -> AppUser Model.
        // Opt1. Write mapping logic here itself.
        // Opt2. Write mapping logic in different class and call the mapping method of that class from here itself.

        // We identified oneProblem that problem is to register user we need List<Skill>
        // We are having List<String> we need to fecth all the Skill object from the database api

        // We need to fetch List<Skill> from Db API for List<String>
        List<String> skillNames = jobSeekerDto.getSkillSet();
        List<Skill> skills = skillService.getAllSkills(skillNames);
        AppUser jobSeeker = mappingUtility.mapJobSeekerDetailsToAppUser(jobSeekerDto, skills);
        AppUser user  = this.saveUser(jobSeeker);
        return user;
    }

    public boolean validateCredentials(String email, String password){
        // We need to call database api to provide user object on the basis of email.
        // So to call database api we should call database-api connector class.
        AppUser user  = dbApiConnector.callGetUserByEmailEndpoint(email);
        if(user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public String decryptJwtToken(String token){
        String payload = Jwts.parser().setSigningKey(secretPassword)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return payload;
    }

    public AppUser getUserFromToken(String token){
        String email = this.decryptJwtToken(token).split(":")[0];
        return dbApiConnector.callGetUserByEmailEndpoint(email);
    }

    public boolean isAdminUser(AppUser user){
        return user.getUserType().equals("ADMIN") ?  true : false;
    }

    public boolean isUserRecruiter(AppUser user){
        return user.getUserType().equals("RECRUITER") ? true : false;
    }

    public AppUser getUserByEmail(String email){
        return dbApiConnector.callGetUserByEmailEndpoint(email);
    }


    AppUser saveUser(AppUser user){
        // This method will be having logic to call SaveUser endpoint of appuser controller of dbApi
        return dbApiConnector.callSaveUserEndpoint(user);
    }

}
