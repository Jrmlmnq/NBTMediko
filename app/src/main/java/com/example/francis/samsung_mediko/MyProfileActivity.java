package com.example.francis.samsung_mediko;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyProfileActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser loggedIn;
    private DatabaseReference dbUser;
    private User user;

    private TextView tvName;
    private TextView tvNoDoc;
    private TextView tvNoPres;
    private TextView tvNoDeli;
    private TextView tvEmail;
    private TextView tvCpNo;
    private TextView tvAddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page_here);

        mAuth = FirebaseAuth.getInstance();
        loggedIn = mAuth.getCurrentUser();
        dbUser = FirebaseDatabase.getInstance().getReference().child("users").child(loggedIn.getUid());

        tvName = findViewById(R.id.name);
        tvNoDoc = findViewById(R.id.noDoc);
        tvNoPres = findViewById(R.id.noPres);
        tvNoDeli = findViewById(R.id.noDeli);
        tvEmail = findViewById(R.id.email);
        tvCpNo = findViewById(R.id.cpNo);
        tvAddress = findViewById(R.id.address);

        dbUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
                tvName.setText(user.getFirstName() + " " + user.getmI() + ". " + user.getLastName());
                if (user.getDoctorKeys() == null)
                    tvNoDoc.setText("0");
                else tvNoDoc.setText(user.getDoctorKeys().size());
                tvEmail.setText(user.getEmail());
                tvCpNo.setText(user.getCpNo());
                tvAddress.setText(user.getAddress());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });
    }
}
