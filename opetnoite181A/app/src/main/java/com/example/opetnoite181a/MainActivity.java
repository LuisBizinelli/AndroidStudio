package com.example.opetnoite181a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.group1);
    }

    public void verificar(View view) {
        int id = radioGroup.getCheckedRadioButtonId();

        String texto = "";
        switch (id){
            case R.id.radio1_1:
                texto = "opção 1 selecionada";
                break;
            case R.id.radio2_1:
                texto = "opção 2 selecionada";
                break;
        }

        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    }
}
