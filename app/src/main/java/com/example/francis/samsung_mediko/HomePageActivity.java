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
        CardView listOfMedicines = (CardView) findViewById(R.id.medicineList);
        CardView listOfSymptoms  = findViewById(R.id.symptomsList);
      CardView deliveryStatus  = (CardView) findViewById(R.id.deliveryStatus);
        CardView myDoctors       = (CardView) findViewById(R.id.myDoctors);
        CardView myProfile       = (CardView) findViewById(R.id.myProfile);
        CardView samsungBtn      = (CardView) findViewById(R.id.samsungBtn);

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
