package com.example.francis.samsung_mediko;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class MyDoctorsFragment extends DoctorListFragment {
    public MyDoctorsFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // All my posts
        return databaseReference.child("doctors").child("doctor_1");

    }
}
