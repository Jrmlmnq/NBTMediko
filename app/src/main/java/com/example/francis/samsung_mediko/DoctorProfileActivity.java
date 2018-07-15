package com.example.francis.samsung_mediko;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DoctorProfileActivity extends AppCompatActivity {
    private static final String TAG = "DoctorProfileActivity";
    public static final String EXTRA_POST = "doctor_key";

    private String doctorKey;

    private ImageButton btnBack;
    private TextView tvName;
    private TextView tvGender;
    private TextView tvDesc;

    private DatabaseReference docRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_profile);

        doctorKey = getIntent().getStringExtra(EXTRA_POST);
        if (doctorKey == null) {
            throw new IllegalArgumentException("Must pass extra_post_key");
        }

        docRef = FirebaseDatabase.getInstance().getReference()
                .child("doctors")
                .child(doctorKey);

        tvName = findViewById(R.id.doctorName);
        tvGender = findViewById(R.id.gender);
        tvDesc = findViewById(R.id.description);

        btnBack = findViewById(R.id.backBtn);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        docRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Doctor d = dataSnapshot.getValue(Doctor.class);
                tvName.setText(d.getFirstName() + " " + d.getLastName());
                tvGender.setText(d.getGender());
                tvDesc.setText(d.getDesc());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });
    }
}
