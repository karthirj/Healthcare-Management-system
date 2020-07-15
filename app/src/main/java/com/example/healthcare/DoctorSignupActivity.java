package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DoctorSignupActivity extends AppCompatActivity {

    EditText name , email , contactno , yrs_of_experience  , password , cpassword;
    Button bt_signup , bt_cancel;
    Spinner spinnerSpecializationDrSignup,spinnerDayAvailablity;
    static public String DOCTOR_KEY = "DOCTOR";
    String specialization,availability;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Doctor doctor = new Doctor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_signup);
        setTitle("Doctor's SignUp");


        name = findViewById(R.id.et_name);
        email = findViewById(R.id.et_email);
        spinnerSpecializationDrSignup = findViewById(R.id.spinnerSpecializationDrSignup);
        contactno = findViewById(R.id.et_contact);
        yrs_of_experience = findViewById(R.id.et_experience);
        spinnerDayAvailablity = findViewById(R.id.spinnerDayAvailablity);
        password = findViewById(R.id.et_password);
        cpassword = findViewById(R.id.et_cpassword);
        bt_signup = findViewById(R.id.bt_signup);
        bt_cancel = findViewById(R.id.bt_cancel);

        final String[] item_specialization = new String[]{"Pediatrician", "Cardiologist", "Dentist" , "Dermatologist" , "Neurologist" , "Psychiatrist"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, item_specialization);
        spinnerSpecializationDrSignup.setAdapter(adapter);

        spinnerSpecializationDrSignup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                specialization = item_specialization[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final String[] item_dayAvailability = new String[]{"Monday", "Tuesday", "Wednesday" , "Thursday" , "Friday" , "Saturday","Sunday"};
        ArrayAdapter<String> adapterDayAvailability = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, item_dayAvailability);
        spinnerDayAvailablity.setAdapter(adapterDayAvailability);

        spinnerDayAvailablity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                availability = item_dayAvailability[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             doctor = new Doctor(name.getText().toString(),email.getText().toString(),specialization,yrs_of_experience.getText().toString(),contactno.getText().toString()
                    ,availability,password.getText().toString(),cpassword.getText().toString());
            doctor.toHashMap();

            db.collection("Doctors").add(doctor).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                @Override
                public void onComplete(@NonNull Task<DocumentReference> task) {

                    if(task.isSuccessful()){


                        Toast.makeText(DoctorSignupActivity.this, "Sign up successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DoctorSignupActivity.this,DoctorMainActivity.class);
                        intent.putExtra(DOCTOR_KEY,doctor);
                        startActivity(intent);
                        finish();



                    }


                }
            });


            }
        });

        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DoctorSignupActivity.this, DoctorLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });







    }

}
