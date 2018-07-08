package com.example.francis.samsung_mediko;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MedicinesListActivity extends AppCompatActivity {

    RecyclerView rv;
    MyAdapter myAdapter;
    List<Medicine> lMedicines;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicineslist_activity);

        rv = findViewById(R.id.medicineListContainer);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));

        lMedicines = new ArrayList<>();

        myAdapter = new MyAdapter(lMedicines);

        firebaseDatabase = FirebaseDatabase.getInstance();

        getDataFromFirebase();
    }

    public void getDataFromFirebase() {
        dbRef = firebaseDatabase.getReference().child("medicines");
        dbRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Medicine m = new Medicine();
                m = dataSnapshot.getValue(Medicine.class);

                lMedicines.add(m);
                rv.setAdapter(myAdapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {}
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });
    }

    private class MyAdapter extends  RecyclerView.Adapter<MyAdapter.MedicineViewHolder>{
        List<Medicine> listArray;

        public MyAdapter(List<Medicine> listArray) { this.listArray = listArray; }

        @NonNull
        @Override
        public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicinelist, parent, false);
            return new MedicineViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MedicineViewHolder holder, int position) {
            Medicine m = new Medicine();
            m = listArray.get(position);
            holder.name.setText(m.getName());
            holder.type.setText(m.getSymptoms());
            holder.price.setText("Php" + m.getPrice());
        }

        @Override
        public int getItemCount() { return listArray.size(); }

        public class MedicineViewHolder extends RecyclerView.ViewHolder {

            TextView name;
            TextView type;
            TextView price;

            public MedicineViewHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.medicineName);
                type = itemView.findViewById(R.id.medicineType);
                price = itemView.findViewById(R.id.medicinePrice);
            }
        }
    }
}
