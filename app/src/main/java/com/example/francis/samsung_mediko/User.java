package com.example.francis.samsung_mediko;

import java.util.Map;

public class User {

    private String email;
    private String firstName;
    private String lastName;
    private String mI;
    private String gender;
    private Map<String, Boolean> doctorKeys;
    private boolean premium;

    public User(){}


    public User(String email, String firstName, String lastName, String mI, String gender, Map<String, Boolean> doctorKeys, boolean premium) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mI = mI;
        this.gender = gender;
        this.doctorKeys = doctorKeys;
        this.premium = premium;
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

    public Map<String, Boolean> getDoctorKeys() {
        return doctorKeys;
    }

    public void setDoctorKeys(Map<String, Boolean> doctorKeys) {
        this.doctorKeys = doctorKeys;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
