package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PatientDashboardActivity extends AppCompatActivity {

    ImageView book_appt,iv_showAppointements;
    public static String TAG_SEND_PATIENT = "send_patient";
    static Patient patient = new Patient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dashboard);

        book_appt = findViewById(R.id.iv_bk_appt);
        iv_showAppointements = findViewById(R.id.iv_showAppointements);

        if(getIntent()!=null && getIntent().getExtras() != null && patient != null) {

           patient = (Patient) getIntent().getSerializableExtra(PatientDashboardActivity.TAG_SEND_PATIENT);
            Toast.makeText(this, "Welcome " + patient.getName(), Toast.LENGTH_LONG).show();
            setTitle(patient.getName().toString()+"'s Actions");

        }

        book_appt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PatientDashboardActivity.this, Book_Appointment.class);
                intent.putExtra(TAG_SEND_PATIENT,patient);
                startActivity(intent);
               // finish();


            }
        });

        iv_showAppointements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PatientDashboardActivity.this, AppointmentHistoryActivity.class);
                intent.putExtra(TAG_SEND_PATIENT,patient);
                startActivity(intent);
               // finish();


            }
        });








    }
}
