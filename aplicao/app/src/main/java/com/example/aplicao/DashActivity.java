package com.example.aplicao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class DashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        Log.d("CLICO", "onCreate executado (DashActivity)");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("CLICO", "onStart executado (DashActivity)");
    }

    @Override
    protected void onResume(){
        super.onResume();

        Log.d("CLICO", "onResume executado (DashActivity)");
    }

    @Override
    protected void onPause(){
        super.onPause();

        Log.d("CLICO", "onPause executado (DashActivity)");
    }

    @Override
    protected void onStop(){
        super.onStop();

        Log.d("CLICO", "onStop executado (DashActivity)");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        Log.d("CLICO", "onDestroy executado (DashActivity)");
    }
}
