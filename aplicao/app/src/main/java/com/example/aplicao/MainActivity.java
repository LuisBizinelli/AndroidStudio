package com.example.aplicao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("CLICO", "onCreate executado (mainactivity)");

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("CLICO", "onStart executado (mainactivity)");
    }

    @Override
    protected void onResume(){
        super.onResume();

        Log.d("CLICO", "onResume executado (mainactivity)");
    }

    @Override
    protected void onPause(){
        super.onPause();

        Log.d("CLICO", "onPause executado (mainactivity)");
    }

    @Override
    protected void onStop(){
        super.onStop();

        Log.d("CLICO", "onStop executado (mainactivity)");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        Log.d("CLICO", "onDestroy executado (mainactivity)");
    }

    public void trocarTela(View View){
        Intent intent = new Intent(MainActivity.this,DashActivity.class);
        startActivity(intent);
    }
}
