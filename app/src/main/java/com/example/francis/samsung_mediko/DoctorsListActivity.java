package com.example.francis.samsung_mediko;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DoctorsListActivity extends AppCompatActivity {

    RecyclerView rv;
    MyAdapter myAdapter;
    List<Doctor> lDoctors;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorslist_activity);

        rv = (RecyclerView) findViewById(R.id.doctorListContainer);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));

        lDoctors = new ArrayList<>();

        myAdapter = new MyAdapter(lDoctors);

        firebaseDatabase = FirebaseDatabase.getInstance();

        getDataFromFirebase();
    }

    public void getDataFromFirebase(){
        dbRef = firebaseDatabase.getReference().child("doctors");

        dbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Doctor d = new Doctor();
                d = dataSnapshot.getValue(Doctor.class);

                lDoctors.add(d);

                rv.setAdapter(myAdapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.DoctorViewHolder>{
        List<Doctor> listArray;

        public MyAdapter(List<Doctor> listArray){
            this.listArray = listArray;
        }

        @NonNull
        @Override
        public DoctorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctorlist, parent, false);

            return new DoctorViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
            Doctor d = new Doctor();
            d = listArray.get(position);

            holder.desc.setText(d.getDesc());
            holder.name.setText(d.getFirstName() + " "+ d.getLastName());
        }

        @Override
        public int getItemCount() {
            return listArray.size();
        }

        public class DoctorViewHolder extends RecyclerView.ViewHolder{

           TextView name;
           TextView desc;

           public DoctorViewHolder(View itemView) {
               super(itemView);
               name = (TextView) itemView.findViewById(R.id.doctorName);
               desc = (TextView) itemView.findViewById(R.id.doctorDescription);
           }
       }
    }
}
