package com.example.francis.samsung_mediko;

import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailedMedicineActivity extends AppCompatActivity{
    private static final String TAG = "DetailedMedicineActivity";
    public static final String EXTRA_POST = "medicine_key";

    private String medicineKey;

    private DatabaseReference medicineReference;

    private ImageButton backBtn;
    private ImageView medicinePic;
    private ImageButton addToCartBtn;
    private TextView  medicineName;
    private TextView  detailedMedicinePrice;
    private TextView  symptomsName;
    public Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine_details);

        medicineKey = getIntent().getStringExtra(EXTRA_POST);
        if (medicineKey == null) {
            throw new IllegalArgumentException("Must pass extra_post_key");
        }

        medicineReference = FirebaseDatabase.getInstance().getReference()
                .child("medicines")
                .child(medicineKey);

        //Initialize Views / Layout items
        // ids :
        // backBtn
        backBtn = (ImageButton) findViewById(R.id.backBtn);
        // medicinePic
        medicinePic = (ImageView) findViewById(R.id.medicinePic);
        // medicineName
        medicineName = (TextView) findViewById(R.id.medicineName);
        // addToCartBtn
        addToCartBtn = (ImageButton) findViewById(R.id.addToCartBtn);
        // detailedMedicinePrice
        detailedMedicinePrice = (TextView) findViewById(R.id.detailedMedicinePrice);
        //symptomsName
        symptomsName = (TextView) findViewById(R.id.symptomsName);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2100); // As I am using LENGTH_LONG in Toast
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
        @Override
        public void onStart(){
            super.onStart();

            medicineReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.i("snapshot", dataSnapshot.child(medicineKey) + "");
                    Medicine m = dataSnapshot.getValue(Medicine.class);
                    //for drawable thingy
//                int id = getResources().getIdentifier("yourpackagename:drawable/" + medicineName, null, null);
//                medicinePic.setImageResource(id);
                    Log.i("Medicine Name:", m.getName());
                    medicineName.setText(m.getName().toString());
                    float p = m.getPrice();
                    detailedMedicinePrice.setText(Float.toString(p));
                    symptomsName.setText(m.getSymptoms().toString());
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.w("TAG", "postComments:onCancelled", databaseError.toException());
                    Toast.makeText(getBaseContext(), "Failed to load comments.",
                            Toast.LENGTH_SHORT).show();

                    thread.start();
                }
            });
        }
    }


