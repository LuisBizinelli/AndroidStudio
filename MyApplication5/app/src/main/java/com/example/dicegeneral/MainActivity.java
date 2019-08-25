package com.example.dicegeneral;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView textScore, textSequence, textPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textScore = findViewById(R.id.textScore);
        textSequence = findViewById(R.id.textSequence);
        textPlay = findViewById(R.id.textPlay);
    }

    public void initiateGame(View view) {
        List<Integer> dices = throwDices(5);
        printSequence(dices, textPlay);

        String resultClassification = getDicesThrowsResult(dices);
        int resultPoints = getPoints(resultClassification, dices);

        textScore.setText(String.format("Score - %d", resultPoints));
        textSequence.setText(String.format("Classification - %s", resultClassification));
    }

    private int getPoints(String result, List<Integer> dices) {
        if (result.equalsIgnoreCase("Full-hand"))
            return 25;
        else if (result.equalsIgnoreCase("General"))
            return 50;
        else if (result.equalsIgnoreCase("Trinca")
                || result.equalsIgnoreCase("Trinca")) {
            int sum = 0;
            for (Integer d : dices) {
                sum += d;
            }
            return sum;
        } else if (result.equalsIgnoreCase("Sequencia Baixa"))
            return 40;
        else if (result.equalsIgnoreCase("Sequencia Alta"))
            return 30;
        else
            return 0;
    }

    private List<Integer> throwDices(int unit) {
        List<Integer> dices = new ArrayList<>();
        for (int i = 0; i < unit; i++) {
            int var = (int) (Math.random() * 6) + 1;
            dices.add(var);
        }
        return dices;
    }

    private void printSequence(List<Integer> dices, TextView textPlay) {
        textPlay.setText("");
        for (int i = 0; i < dices.size(); i++) {
            textPlay.append(String.format("Dice %d is %d\n", i+1, dices.get(i)));
        }
    }

    private String getDicesThrowsResult(List<Integer> dices) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Integer dice : dices) {
            if (countMap.containsKey(dice))
                countMap.put(dice, countMap.get(dice) + 1);
            else
                countMap.put(dice, 1);
        }

        return getClassification(dices, countMap);
    }

    private String getClassification(List<Integer> dices, Map<Integer, Integer> countMap) {
        if (countMap.containsValue(2) && countMap.containsValue(3))
            return "Full-hand";
        else if (countMap.containsValue(5))
            return "General";
        else if (countMap.containsValue(3))
            return "Trinca";
        else if (countMap.containsValue(4))
            return "Quadra";
        else if (countMap.containsValue(1) && countMap.size() == 5){
            if (countMap.containsKey(1))
                return "Sequencia Baixa";
            else
                return "Sequencia Alta";
        } else {
            return "Duplas";
        }
    }
}
