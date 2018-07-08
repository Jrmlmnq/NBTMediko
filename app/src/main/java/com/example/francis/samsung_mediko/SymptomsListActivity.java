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

import java.util.ArrayList;
import java.util.List;

public class SymptomsListActivity extends AppCompatActivity {

    RecyclerView rv;
    MyAdapter2 myAdapter;
    List<Symptoms> lSymptoms;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symptomslist_activity);

        rv = (RecyclerView) findViewById(R.id.symptomsList);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));

        lSymptoms = new ArrayList<>();

        myAdapter = new MyAdapter2(lSymptoms);

        firebaseDatabase = FirebaseDatabase.getInstance();

        getDataFromFirebase();
    }

    public void getDataFromFirebase(){
        dbRef = firebaseDatabase.getReference().child("symptoms");

        dbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Symptoms symptoms = new Symptoms();
                symptoms = dataSnapshot.getValue(Symptoms.class);

                lSymptoms.add(symptoms);

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

    public class MyAdapter2 extends  RecyclerView.Adapter<MyAdapter2.SymptomsViewHolder>{
        List<Symptoms> listArray;

        public MyAdapter2(List<Symptoms> listArray){
            this.listArray = listArray;
        }

        @NonNull
        @Override
        public SymptomsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.symptomslist, parent, false);

            return new MyAdapter2.SymptomsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyAdapter2.SymptomsViewHolder holder, int position) {
            Symptoms s = new Symptoms();
            s = listArray.get(position);

//            holder.desc.setText(d.getDesc());
            holder.name.setText(s.getName());
        }

        @Override
        public int getItemCount() {
            return listArray.size();
        }

        public class SymptomsViewHolder extends RecyclerView.ViewHolder{

            TextView name;
//            TextView desc;

            public SymptomsViewHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.symptomName);
//                desc = (TextView) itemView.findViewById(R.id.doctorDescription);
            }
        }
    }
}
