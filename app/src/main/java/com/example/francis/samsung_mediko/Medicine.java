package com.example.francis.samsung_mediko;

public class Medicine {

    private String name;
    private String description;
    private float dosage;
    private float price;
    private String ages;
    private String medicineType;
    private String symptoms;
    private String sideEffects;

    public Medicine(){}

    public Medicine(String name, String description, float dosage, float price, String ages, String medicineType, String symptoms, String sideEffects) {
        this.name = name;
        this.description = description;
        this.dosage = dosage;
        this.price = price;
        this.ages = ages;
        this.medicineType = medicineType;
        this.symptoms = symptoms;
        this.sideEffects = sideEffects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getDosage() {
        return dosage;
    }

    public void setDosage(float dosage) {
        this.dosage = dosage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }
}
