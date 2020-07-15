package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class DoctorLoginActivity extends AppCompatActivity {

    EditText et_email,et_password;
    Button bt_login , bt_signup;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    HashMap<String,Object> doctor_HashMap = new HashMap<>();
    Doctor doctor = new Doctor();
    static public String DOCTOR_KEY = "DOCTOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);
        setTitle("Doctor's Login");

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        bt_login = findViewById(R.id.bt_login);
        bt_signup = findViewById(R.id.bt_signup);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                db.collection("Doctors")
                        .whereEqualTo("email", et_email.getText().toString()).whereEqualTo("password",et_password.getText().toString())
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d("Hi", document.getId() + " => " + document.getData());
                                        Log.d("Hello",document.getData().toString());
                                      doctor_HashMap = (HashMap<String, Object>) document.getData();
                                      doctor.toDoctor(doctor_HashMap);
                                      Log.d("Doctor Name",doctor.name.toString());
                                      Toast.makeText(DoctorLoginActivity.this, doctor.getName().toString(), Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(DoctorLoginActivity.this, DoctorMainActivity.class);
                                        intent.putExtra(DOCTOR_KEY,doctor);
                                        startActivity(intent);
                                        finish();
                                    }
                                } else {
                                    Log.d("Hi", "Error getting documents: ", task.getException());
                                }
                            }
                        });

            }
        });

        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DoctorLoginActivity.this, DoctorSignupActivity.class);
                startActivity(intent);
               // finish();

            }
        });



    }
}
