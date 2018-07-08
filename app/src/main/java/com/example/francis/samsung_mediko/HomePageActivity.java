package com.example.francis.samsung_mediko;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class HomePageActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser loggedInUser;
    private DatabaseReference dbUser;
    private User user;
    TextView tvName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the different image buttons here
        CardView listOfMedicines = (CardView) findViewById(R.id.toMedicineList);
        CardView listOfSymptoms  = (CardView) findViewById(R.id.toSymptomsList);
        CardView deliveryStatus  = (CardView) findViewById(R.id.toDeliveryStatus);
        CardView myDoctors       = (CardView) findViewById(R.id.toDoctorList);
        CardView myProfile       = (CardView) findViewById(R.id.toMyProfile);
        CardView samsungBtn      = (CardView) findViewById(R.id.toSamsung321);

        tvName = (TextView) findViewById(R.id.nameLabel);

        mAuth = FirebaseAuth.getInstance();
        loggedInUser = mAuth.getCurrentUser();
        dbUser = FirebaseDatabase.getInstance().getReference().child("users").child(loggedInUser.getUid());

        dbUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
                tvName.setText((user.getFirstName() + " " + user.getLastName()));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });

        //set the action listeners for  the different
        listOfMedicines.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

        listOfSymptoms.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), SymptomsListActivity.class));
            }
        });

        deliveryStatus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

        myDoctors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), DoctorsListActivity.class));
            }
        });

        myProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), MyProfileActivity.class));
            }
        });

        samsungBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
    }
}
