package com.example.francis.samsung_mediko;

import com.google.android.gms.maps.model.LatLng;

public class Deliverer {

    private String email;
    private String firstName;
    private String lastName;
    private String contactNo;
    private LatLng location;

    public Deliverer(){}

    public Deliverer(String email, String firstName, String lastName, String contactNo, LatLng location) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.location = location;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }
}
