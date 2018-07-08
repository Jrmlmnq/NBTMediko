package com.example.francis.samsung_mediko;

import java.util.Map;

public class Doctor {

    private String email;
    private String firstName;
    private String lastName;
    private String mI;
    private String gender;
    private String uid;
    private String desc;
    private Map<String, Boolean> hospitalKeys;
    private Map<String, Boolean> patientKeys;
    private boolean atWork;

    public Doctor(){}

    public Doctor(String firstName, String lastName, String email, String desc){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.desc = desc;

    }

    public Doctor(String email, String firstName, String lastName, String desc, String mI, String gender, Map<String, Boolean> hospitalKeys, Map<String, Boolean> patientKeys, boolean atWork) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.desc = desc;
        this.mI = mI;
        this.gender = gender;
        this.hospitalKeys = hospitalKeys;
        this.patientKeys = patientKeys;
        this.atWork = atWork;
    }

    public void setUid(String uid){this.uid = uid;}

    public String getUid() { return this.uid;}
    public String getEmail() {
        return email;
    }

    public String getDesc() {return this.desc;}
    public void setDesc(String desc){this.desc = desc;}

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getmI() {
        return mI;
    }

    public void setmI(String mI) {
        this.mI = mI;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Map<String, Boolean> getHospitalKeys() {
        return hospitalKeys;
    }

    public void setHospitalKeys(Map<String, Boolean> hospitalKeys) {
        this.hospitalKeys = hospitalKeys;
    }

    public Map<String, Boolean> getPatientKeys() {
        return patientKeys;
    }

    public void setPatientKeys(Map<String, Boolean> patientKeys) {
        this.patientKeys = patientKeys;
    }

    public boolean isAtWork() {
        return atWork;
    }

    public void setAtWork(boolean atWork) {
        this.atWork = atWork;
    }
}
