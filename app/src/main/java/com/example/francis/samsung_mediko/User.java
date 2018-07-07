package com.example.francis.samsung_mediko;

import com.google.android.gms.maps.model.LatLng;

import java.util.Map;

public class User {

    private String email;
    private String firstName;
    private String lastName;
    private String mI;
    private String cpNo;
    private String address;
    private LatLng geoLoc;
    private Map<String, Boolean> doctorKeys;
    private boolean premium;

    public User(){}

    public User(String email, String firstName, String lastName, String mI, String cpNo, String address, LatLng geoLoc, Map<String, Boolean> doctorKeys, boolean premium) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mI = mI;
        this.cpNo = cpNo;
        this.address = address;
        this.geoLoc = geoLoc;
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

    public String getCpNo() {
        return cpNo;
    }

    public void setCpNo(String cpNo) {
        this.cpNo = cpNo;
    }

    public Map<String, Boolean> getDoctorKeys() {
        return doctorKeys;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LatLng getGeoLoc() {
        return geoLoc;
    }

    public void setGeoLoc(LatLng geoLoc) {
        this.geoLoc = geoLoc;
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
