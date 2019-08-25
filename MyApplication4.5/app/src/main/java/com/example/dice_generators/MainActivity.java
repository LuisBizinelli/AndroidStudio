package com.example.dice_generators;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /**
     * Criar um App que o usuário informe a quantidade de dados que deseja lançar e a
     * quantidade de faces do dado. Mostrar o resultado da soma dos lançamentos e quais
     * os valores para cada dado
     *
     * @param savedInstanceState
     */

    private TextView textResult, textSum, textDices, textFaces;
    private SeekBar seekFaces, seekDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.textResult);
        textSum = findViewById(R.id.textSum);
        textDices = findViewById(R.id.textDices);
        textFaces = findViewById(R.id.textFaces);

        seekFaces = findViewById(R.id.seekFaces);
        seekDice = findViewById(R.id.seekDice);

        getSeekFacesValue(seekFaces);
        getSeekDiceValue(seekDice);
    }

    public void initiate(View view) {
        int dices = seekDice.getProgress();
        int faces = seekFaces.getProgress();

        int[] var = calculateSum(faces, dices);

        generateResults(var);
    }

    private int[] calculateSum(int faces, int dices) {
        int[] var = new int[dices];
        int result = 0;

        for (int i = 0; i < var.length; i++) {
            var[i] = (int) (Math.random() * faces) + 1;
            result += var[i];
        }

        textSum.setText(String.format("Sum - %d", result));

        return var;
    }

    private void generateResults(int[] var) {
        textResult.setText("");
        for (int i = 0; i < var.length; i++) {
            textResult.append(String.format("Dice %d is %d \n", i+1, var[i]));
        }
    }

    private void getSeekDiceValue(SeekBar seekDice) {
        seekDice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textDices.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void getSeekFacesValue(SeekBar seekFaces) {
        seekFaces.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textFaces.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
