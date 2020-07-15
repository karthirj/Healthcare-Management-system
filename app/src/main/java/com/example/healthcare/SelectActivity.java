package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class SelectActivity extends AppCompatActivity {

    ImageView doctor;
    ImageView patient;
    ImageView pharmacy;
    ImageView lab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        setTitle("Dashboard");

        doctor = findViewById(R.id.iv_doctor);
        patient = findViewById(R.id.iv_patient);
        pharmacy = findViewById(R.id.iv_pharmacy);
        lab = findViewById(R.id.iv_lab);

        if(isConnected()){
            Toast.makeText(SelectActivity.this, "Select an option", Toast.LENGTH_LONG).show();

            patient.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, PatientLoginActivity.class);
                    startActivity(intent);
                   // finish();
                }
            });

            doctor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, DoctorLoginActivity.class);
                    startActivity(intent);
                    //finish();
                }
            });
            pharmacy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, PharmacyLoginActivity.class);
                    startActivity(intent);
                   // finish();
                }
            });
            lab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, LabLoginActivity.class);
                    startActivity(intent);
                   // finish();
                }
            });


            /*patient.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, PatientLoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });*/
        }
        else{
            Toast.makeText(SelectActivity.this, "No Internet!, Please connect to the internet", Toast.LENGTH_LONG).show();
        }

    }
    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected() ||
                (networkInfo.getType() != ConnectivityManager.TYPE_WIFI
                        && networkInfo.getType() != ConnectivityManager.TYPE_MOBILE)) {
            return false;
        }
        return true;
    }
}
