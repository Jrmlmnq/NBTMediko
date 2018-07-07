package com.example.francis.samsung_mediko;

import java.util.Map;

public class Prescription {

    private String doctorKey;
    private String userKey;
    private Map<String, Integer> medicineCount;

    public Prescription(){}

    public Prescription(String doctorKey, String userKey, Map<String, Integer> medicineCount) {
        this.doctorKey = doctorKey;
        this.userKey = userKey;
        this.medicineCount = medicineCount;
    }

    public String getDoctorKey() {
        return doctorKey;
    }

    public void setDoctorKey(String doctorKey) {
        this.doctorKey = doctorKey;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public Map<String, Integer> getMedicineCount() {
        return medicineCount;
    }

    public void setMedicineCount(Map<String, Integer> medicineCount) {
        this.medicineCount = medicineCount;
    }
}
