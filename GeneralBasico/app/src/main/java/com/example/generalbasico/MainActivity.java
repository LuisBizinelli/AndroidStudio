package com.example.generalbasico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Vencedor, Dados;
    private Button Jogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Vencedor = findViewById(R.id.Vencedor);
        Dados = findViewById(R.id.Dados);

        Jogar = findViewById(R.id.Jogar);

    }
}
