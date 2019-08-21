package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private EditText editPessoas;
    private TextView textValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        editPessoas = findViewById(R.id.editPessoas);
        textValor = findViewById(R.id.textValor);
    }

    public void calcularDivisaoChurrasco(View view) {
        double resultado = Double.parseDouble(editValor.getText().toString()) /
                Integer.parseInt(editPessoas.getText().toString());

        textValor.setText(String.format(Locale.getDefault(),
                "R$ %.2f", resultado));
    }
}
