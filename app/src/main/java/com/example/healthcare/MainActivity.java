package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button home;
    private TextView welcome;

    private  static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MED-Konnect: Enhancing Life");
//
//        home = findViewById(R.id.welcome_bt);
//        welcome = findViewById(R.id.tv_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(isConnected()) {
                    Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "No Internet!, Please connect to the internet", Toast.LENGTH_LONG).show();
                }

            }
        },SPLASH_TIME_OUT);



//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(isConnected()) {
//                    Intent intent = new Intent(MainActivity.this, SelectActivity.class);
//                    startActivity(intent);
//                }
//                else{
//                    Toast.makeText(MainActivity.this, "No Internet!, Please connect to the internet", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
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
