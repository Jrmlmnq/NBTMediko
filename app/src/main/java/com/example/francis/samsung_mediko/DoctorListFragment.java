package com.example.francis.samsung_mediko;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public abstract class DoctorListFragment extends Fragment {
    private static final String TAG = "DoctorListFragment";
    private DatabaseReference mDatabase;

    private FirebaseRecyclerAdapter<Doctor, DoctorViewHolder> mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.doctorlist, container, false);


        return view;
    }

    public abstract Query getQuery(DatabaseReference databaseReference);
}
