package com.example.francis.samsung_mediko;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.zip.Inflater;

public class DoctorsListActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorslist_activity);

        RecyclerView rv = (RecyclerView) findViewById(R.id.doctorListContainer);

        final DatabaseReference doctorDBReference = FirebaseDatabase.getInstance()
                      .getReference()
                      .child("doctors");

        Query query = doctorDBReference;
        Log.i("QUERY:" , query.toString());
        FirebaseRecyclerOptions firebaseDoctorOptions = new FirebaseRecyclerOptions.Builder<Doctor>()
                                                            .setQuery(query, Doctor.class)
                                                            .build();

        FirebaseRecyclerAdapter<Doctor, DoctorViewHolder> adapter = new FirebaseRecyclerAdapter<Doctor, DoctorViewHolder>(firebaseDoctorOptions){

            @Override
            public DoctorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctorlist, parent, false);

                return new DoctorViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(DoctorViewHolder holder, int position, Doctor model) {
                Log.i("DoctorName:", model.getFirstName() + " " + model.getLastName());
                Log.i("DoctorDesc", model.getDesc() + " ");
                holder.doctorName.setText(model.getFirstName() + " " + model.getLastName());
                holder.doctorDescription.setText(model.getDesc());

                String key = getRef(position).getKey();
                holder.itemView.setTag(key);
            }

            /*
            @Override
            protected void populateViewHolder(DoctorViewHolder viewHolder, Doctor model, int position) {

                /*
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getBaseContext(), ViewPostActivity.class);
                        intent.putExtra(Post.EXTRA_KEY, view.getTag().toString());
                        startActivity(intent);
                    }
                });

            }
            */
        };


        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
    }
}
