package com.example.generalbasico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textVencedor, textDados;
    private SeekBar seekPlayer, seekDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textVencedor = findViewById(R.id.textVencedor);
        textDados = findViewById(R.id.textDados);

        seekPlayer = findViewById(R.id.seekPlayer);
        seekDados = findViewById(R.id.seekDados);
    }

    public void Jogar(View view) {

        int Players = seekPlayer.getProgress();
        int dados = seekDados.getProgress();

        int[] var = Vencedor(Players,dados);

        gerarResultado(var);

    }

    private int[] Vencedor(int players, int dados) {
        int[] var = new int[dados];

        int resultado = 0;

        for (int i = 0; i < var.length; i++) {

            var[i] = (int) (Math.random() * players) + 1;

            resultado += var[i];

        }

        textVencedor.setText(String.format("soma - %d", resultado));



        return var;

    }

    private void gerarResultado(int[] var) {

        textDados.setText("");

        for (int i = 0; i < var.length; i++) {

            textDados.append(String.format("dado %d é %d \n", i+1, var[i]));

        }
        

    }

}
