package com.naukri.central_api.service;

import com.naukri.central_api.connectors.DatabaseApiConnector;
import com.naukri.central_api.dto.CompanyRegistrationDto;
import com.naukri.central_api.dto.RecruiterDetailsDto;
import com.naukri.central_api.exceptions.UnAuthorizedException;
import com.naukri.central_api.models.AppUser;
import com.naukri.central_api.models.Company;
import com.naukri.central_api.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    MappingUtility mappingUtility;
    DatabaseApiConnector dbApiConnector;

    UserService userService;

    @Autowired
    public CompanyService(MappingUtility mappingUtility,
                          DatabaseApiConnector dbApiConnector,
                          UserService userService){
        this.mappingUtility = mappingUtility;
        this.dbApiConnector = dbApiConnector;
        this.userService = userService;
    }

    /**
     * Expectation of this function is to save company details in the company table
     * To Save company details it will be calling database Api connector which will be hitting request to
     * database api company controller save endpoint
     * @return Company
     */
    public Company registerCompany(CompanyRegistrationDto companyRegistrationDto){
        // Now we need to map companyregistrationdto details to company class.
        Company company = mappingUtility.mapCompanyDtoToCompanyModel(companyRegistrationDto);
        // Now we need to save this company model inside our database.
        company  = this.saveCompany(company);
        // Now we should create admin account for the company.
        AppUser admin = mappingUtility.mapCompanyDtoToAdmin(companyRegistrationDto, company);
        // Now we need to save this admin in the Appuser Table.
        userService.saveUser(admin);
        return company;
    }

    /**
     * This save method will internally call database api connector which will be calling database api save company endpoint.
     * @return Company
     */
    public Company saveCompany(Company company){
        // database api connector to save company details in the company table.
        return dbApiConnector.callSaveCompanyEndpoint(company);
    }

    public AppUser inviteRecruiter(RecruiterDetailsDto recruiterDetailsDto,
                                   String Authorization){
        String token = Authorization.substring(7);
        AppUser admin = userService.getUserFromToken(token);
        if(!userService.isAdminUser(admin)){
            throw new UnAuthorizedException("Invalid Operation");
        }
        Company company = admin.getCompany();
        // We need create user object for the recruiter
        AppUser recruiter = mappingUtility.mapRecruiterDtoToAppUser(recruiterDetailsDto, company);
        userService.saveUser(recruiter);
        // Mail logic
    }

}
