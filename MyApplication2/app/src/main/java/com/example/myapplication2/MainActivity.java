package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editValue;
    private TextView textMean, textPerson;
    private SeekBar seekPerson;
    private CheckBox checkTip;
    private double originalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValue = findViewById(R.id.editValor);
        textPerson = findViewById(R.id.textPessoas);
        textMean = findViewById(R.id.textDivisao);
        seekPerson = findViewById(R.id.seekPessoas);
        checkTip = findViewById(R.id.checkAcrescimo);

        editValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculateTotal();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().isEmpty())
                    originalValue = Double.parseDouble(editable.toString());
            }
        });

        checkTip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                DecimalFormat df = new DecimalFormat("#0.00");

                if(isChecked) {
                    if(!editValue.getText().toString().isEmpty()){
                        double valor = originalValue;
                        valor *= 1.1;

                        editValue.setText(df.format(valor));
                    }
                } else {
                    editValue.setText(df.format(originalValue));
                }
            }
        });

        seekPerson.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textPerson.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                calculateTotal();
            }
        });
    }

    private void calculateTotal() {
        if(!editValue.getText().toString().isEmpty()) {
            double value = Double.parseDouble(editValue.getText().toString());
            double progress = seekPerson.getProgress();
            double result = value / progress;

            DecimalFormat df = new DecimalFormat("#0.00");

            textMean.setText(String.format("R$ %s", df.format(result)));
        }
    }
}
