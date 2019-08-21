package com.example.students_score;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    /**
     * Criar um App que leia 3 notas de um aluno e calcule a média(simples ou ponderada,
     * caso uma checkbox seja marcada). Caso o aluno escolha a média ponderada, usar os pesos 1,
     * 2 e 3 para as notas. Após obter a média, indicar o conceito do aluno de acordo com a tabela
     * a seguir:
     *
     * acima de 9 : A
     * entre 8 e 9: B
     * entre 7 e 8: C
     * entre 4 e 7: D
     * abaixo de 4: E
     *
     * @param savedInstanceState
     */

    private EditText editScore1, editScore2, editScore3;
    private CheckBox checkWeightedAverage;
    private TextView  textScore, textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editScore1 = findViewById(R.id.editScore1);
        editScore2 = findViewById(R.id.editScore2);
        editScore3 = findViewById(R.id.editScore3);

        checkWeightedAverage = findViewById(R.id.checkWeightedAverage);

        textScore = findViewById(R.id.textScore);
        textResult = findViewById(R.id.textResult);
    }

    public void calculateScores(View view) {
        double score1 = Double.parseDouble(editScore1.getText().toString());
        double score2 = Double.parseDouble(editScore2.getText().toString());
        double score3 = Double.parseDouble(editScore3.getText().toString());

        double result;

        if (checkWeightedAverage.isChecked())
            result = calculateWeightedAverage(score1, score2, score3);
        else
            result = calculateSimpleAverage(score1, score2, score3);

        DecimalFormat df = new DecimalFormat("#0.0");

        char classification = evaluateScore(result);

        textScore.setText(String.format("Score %s", df.format(result)));
        textResult.setText(String.format("The Student classification is %s", classification));
    }

    private char evaluateScore(double result) {
        if (result > 9)
            return 'A';
        else if (result > 8 && result <= 9)
            return 'B';
        else if (result > 7 && result <= 8)
            return 'C';
        else if (result > 4 && result <= 7)
            return 'D';
        else
            return 'E';
    }

    private double calculateSimpleAverage(double score1, double score2, double score3) {
        return (score1 + score2 + score3) / 3;
    }

    private double calculateWeightedAverage(double score1, double score2, double score3) {
        int[] scoreWeight = {1, 2, 3};
        return ((score1 * scoreWeight[0]) +
                (score2 * scoreWeight[1]) +
                (score3 * scoreWeight[2])) / (scoreWeight[0] + scoreWeight[1] + scoreWeight[2]);
    }
}
