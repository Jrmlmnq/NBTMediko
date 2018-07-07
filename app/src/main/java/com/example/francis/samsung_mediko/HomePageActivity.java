package com.example.francis.samsung_mediko;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {
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

            }
        });

        samsungBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
    }
}
