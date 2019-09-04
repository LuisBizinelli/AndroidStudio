package com.example.group;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup1, radioGroup2, radioGroup3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = findViewById(R.id.group1);
        radioGroup2 = findViewById(R.id.group2);
        radioGroup3 = findViewById(R.id.group3);
    }

    public void verificar(View view) {
        int id1 = radioGroup1.getCheckedRadioButtonId();
        int id2 = radioGroup2.getCheckedRadioButtonId();
        int id3 = radioGroup3.getCheckedRadioButtonId();

        int acertos = 0;
        if (id1 == R.id.radio1_1)
            acertos++;
        if (id2 == R.id.radio1_2)
            acertos++;
        if (id3 == R.id.radio2_3)
            acertos++;

        String frase = "";

        switch (acertos) {
            case 0:
                frase = "tente de novo seu animal.";
                break;
            case 1:
                frase = "muito bem, voce não tão idiota.";
                break;
            case 2:
                frase = "parabens, voce é um genio da cultura inutil.";
                break;
        }

        Toast.makeText(this, frase, Toast.LENGTH_SHORT).show();
    }
}
