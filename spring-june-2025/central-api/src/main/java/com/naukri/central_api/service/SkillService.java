package com.naukri.central_api.service;

import com.naukri.central_api.connectors.DatabaseApiConnector;
import com.naukri.central_api.models.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {

    DatabaseApiConnector dbApiConnector;
    @Autowired
    public SkillService(DatabaseApiConnector dbApiConnector){
        this.dbApiConnector = dbApiConnector;
    }

    public List<Skill> getAllSkills(List<String> skillNames){
        List<Skill> skillObjs = new ArrayList<>();
        for(int i = 0; i < skillNames.size(); i++){
            String skillName = skillNames.get(i);
            // We need to get the skill object from database by skill name.
            Skill skill =  this.getSkillByName(skillName);
            skillObjs.add(skill);
        }
        return skillObjs;
    }


    public Skill createSkillByName(String skillName){
        Skill skill = new Skill();
        skill.setName(skillName);
        return dbApiConnector.callSaveSkillEndpoint(skill);
    }

    public Skill getSkillByName(String skillName){
        // This function will make call to dbApi skill controller such that we will
        // be bringing skill object from the database.
        // We need to get the skill object from the database api on the basis of skillName
        // We need to call database api from here.
       Skill skill = dbApiConnector.callGetSkillByNameEndpoint(skillName);
       if(skill == null){
           return this.createSkillByName(skillName);
       }
       return skill;
    }


}
