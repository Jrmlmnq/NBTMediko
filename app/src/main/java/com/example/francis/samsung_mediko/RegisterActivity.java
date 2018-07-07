package com.example.francis.samsung_mediko;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity{

    private static final String TAG = "REGISTRATION";
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    public User user;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference refUsers = mDatabase.child("users");
        Button backBtn = (Button) findViewById(R.id.btnBack);
        Button regBtn = (Button) findViewById(R.id.btnReg);

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        regBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String fName = (String) ((TextView) findViewById(R.id.eFName)).getText().toString();
                String lName = (String) ((TextView) findViewById(R.id.eLName)).getText().toString();
                String MI = (String) ((TextView) findViewById(R.id.eMI)).getText().toString();
                String email = (String) ((TextView) findViewById(R.id.eEmail)).getText().toString();
                String cellNo = (String) ((TextView) findViewById(R.id.eCP)).getText().toString();
                String password = (String) ((TextView) findViewById(R.id.ePass)).getText().toString();
                String conf = (String) ((TextView) findViewById(R.id.eConf)).getText().toString();
                String no = (String) ((TextView) findViewById(R.id.eNo)).getText().toString();
                String city = (String) ((TextView) findViewById(R.id.eCity)).getText().toString();
                String street = (String) ((TextView) findViewById(R.id.eStreet)).getText().toString();
                String sub = (String) ((TextView) findViewById(R.id.eSub)).getText().toString();
                if (fName.equals("") || lName.equals("") || MI.equals("")|| email.equals("") || cellNo.equals("")|| password.equals("") ||
                        conf.equals("") || no.equals("") || city.equals("") || street.equals("") || sub.equals(""))
                    Toast.makeText(RegisterActivity.this, "Do not leave any blanks!",
                            Toast.LENGTH_SHORT).show();
                else if (!password.equals(conf))
                    Toast.makeText(RegisterActivity.this, "Passwords do not match!",
                            Toast.LENGTH_SHORT).show();
                else {
                    user = new User();
                    user.setEmail(email);
                    user.setFirstName(fName);
                    user.setLastName(lName);
                    user.setmI(MI);
                    user.setCpNo(cellNo);
                    user.setAddress(no + ", " + street + ", " + sub + ", " + city);
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");

                                        FirebaseUser currUser = mAuth.getCurrentUser();
                                        refUsers.child(currUser.getUid()).setValue(user);
                                        Toast.makeText(RegisterActivity.this, "Successful Registration!",
                                                Toast.LENGTH_SHORT).show();
                                        finish();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(RegisterActivity.this, "Registration failed :(",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}
