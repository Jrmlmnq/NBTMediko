package com.example.francis.samsung_mediko;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailedMedicineActivity extends AppCompatActivity {
    private static final String TAG = "DetailedMedicineActivity";
    private static final String EXTRA_POST = "medicine_key";
    private String medicineKey;

    private DatabaseReference medicineReference;

    private Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine_details);

        medicineKey = getIntent().getStringExtra(EXTRA_POST);
        if(medicineKey == null){
            throw new IllegalArgumentException("Must pass extra_post_key");
        }

        medicineReference = FirebaseDatabase.getInstance().getReference()
                                                          .child("medicine")
                                                          .child(medicineKey);

        //Initialize Views / Layout items

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }

}
