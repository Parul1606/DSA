package com.acciojob.hms.repositries;

import com.acciojob.hms.models.Hospital;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class HospitalRepository {

    HashMap<Integer, Hospital> hospitalDB;

    public HospitalRepository(){
        this.hospitalDB = new HashMap<>();
    }

    public void saveHospital(int id, Hospital hospital){
        hospitalDB.put(id, hospital);
    }

    public Hospital findHospitalById(int id){
        return hospitalDB.get(id);
    }

    public int getTotalHospital(){
        return hospitalDB.size();
    }

    public HashMap<Integer, Hospital> getHospitalMap(){
        return hospitalDB;
    }
}
