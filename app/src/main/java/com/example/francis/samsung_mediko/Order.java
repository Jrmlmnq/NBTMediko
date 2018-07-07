package com.example.francis.samsung_mediko;

import java.util.Map;

public class Order {

    private Map<String, Integer> medicineCount;
    private float totalPrice;
    private String status;
    private String userKey;
    private String delivererKey;

    public Order(){}

    public Order(Map<String, Integer> medicineCount, float totalPrice, String status, String userKey, String delivererKey) {
        this.medicineCount = medicineCount;
        this.totalPrice = totalPrice;
        this.status = status;
        this.userKey = userKey;
        this.delivererKey = delivererKey;
    }

    public Map<String, Integer> getMedicineCount() {
        return medicineCount;
    }

    public void setMedicineCount(Map<String, Integer> medicineCount) {
        this.medicineCount = medicineCount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getDelivererKey() {
        return delivererKey;
    }

    public void setDelivererKey(String delivererKey) {
        this.delivererKey = delivererKey;
    }
}
