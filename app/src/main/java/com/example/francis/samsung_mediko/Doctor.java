package com.example.francis.samsung_mediko;

import java.util.Map;

public class Doctor {

    private String email;
    private String firstName;
    private String lastName;
    private String mI;
    private String gender;
    private Map<String, Boolean> hospitalKeys;
    private Map<String, Boolean> patientKeys;
    private boolean atWork;

    public Doctor(){}

    public Doctor(String email, String firstName, String lastName, String mI, String gender, Map<String, Boolean> hospitalKeys, Map<String, Boolean> patientKeys, boolean atWork) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mI = mI;
        this.gender = gender;
        this.hospitalKeys = hospitalKeys;
        this.patientKeys = patientKeys;
        this.atWork = atWork;
    }

    public String getEmail() {
        return email;
    }

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
