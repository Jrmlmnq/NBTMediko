package com.example.francis.samsung_mediko;

import com.google.android.gms.maps.model.LatLng;

public class Hospital {

    private String name;
    private String contactDetails;
    private String location;
    private LatLng geoLoc;

    public Hospital(){}

    public Hospital(String name, String contactDetails, String location, LatLng geoLoc) {
        this.name = name;
        this.contactDetails = contactDetails;
        this.location = location;
        this.geoLoc = geoLoc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LatLng getGeoLoc() {
        return geoLoc;
    }

    public void setGeoLoc(LatLng geoLoc) {
        this.geoLoc = geoLoc;
    }
}
