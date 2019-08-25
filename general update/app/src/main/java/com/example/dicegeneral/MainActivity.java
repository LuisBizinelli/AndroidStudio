package com.example.dicegeneral;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView textScore, textSequence, textPlay;
    private Set<String> sections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textScore = findViewById(R.id.textScore);
        textSequence = findViewById(R.id.textSequence);
        textPlay = findViewById(R.id.textPlay);

        sections = new HashSet<>();
    }

    public void initiateGame(View view) {
        List<Integer> dices = throwDices(5);
        printSequence(dices, textPlay);

        String resultClassification = getDicesThrowsResult(dices);
        int resultPoints = getPoints(resultClassification, dices);

        textScore.setText(String.format("Score - %d", resultPoints));
        textSequence.setText(String.format("Classification - %s", resultClassification));
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

        return getClassification(countMap);
    }

    private int getPoints(String result, List<Integer> dices) {
        if (result.equalsIgnoreCase("Full House"))
            return 25;
        else if (result.equalsIgnoreCase("Yahtzee"))
            return 50;
        else if (result.equalsIgnoreCase("Three Of A Kind")
                || result.equalsIgnoreCase("Four Of A Kind")
                || result.equalsIgnoreCase("Chance")) {
            int sum = 0;
            for (Integer d : dices) {
                sum += d;
            }
            return sum;
        } else if (result.equalsIgnoreCase("Small Straight"))
            return 40;
        else if (result.equalsIgnoreCase("Large Straight"))
            return 30;
        else
            return 0;
    }

    private String getClassification(Map<Integer, Integer> countMap) {
        if (isFullHouse(countMap))
            return "Full House";
        else if (isYahtzee(countMap))
            return "Yahtzee";
        else if (isThreeOfAKind(countMap))
            return "Three Of A Kind";
        else if (isFourOfAKind(countMap))
            return "Four Of A Kind";
        else if (isStraight(countMap)) {
            if (countMap.containsKey(1))
                return "Small Straight";
            else
                return "Large Straight";
        } else
            return isUpperSection(countMap);
    }

    private boolean isStraight(Map<Integer, Integer> countMap) {
        return countMap.containsValue(1) && countMap.size() == 5
                && sections.add("Small Straight") || sections.add("Large Straight");
    }

    private boolean isFourOfAKind(Map<Integer, Integer> countMap) {
        return countMap.containsValue(4) && sections.add("Four Of A Kind");
    }

    private boolean isThreeOfAKind(Map<Integer, Integer> countMap) {
        return countMap.containsValue(3) && sections.add("Three Of A Kind");
    }

    private boolean isYahtzee(Map<Integer, Integer> countMap) {
        return countMap.containsValue(5) && sections.add("Yahtzee");
    }

    private boolean isFullHouse(Map<Integer, Integer> countMap) {
        return countMap.containsValue(2) && countMap.containsValue(3) && sections.add("Full House");
    }

    private String isUpperSection(Map<Integer, Integer> countMap) {
        if (countMap.containsKey(6) && sections.add("Sixes"))
            return "Sixes";
        else if (countMap.containsKey(5) && sections.add("Fives"))
            return "Fives";
        else if (countMap.containsKey(4) && sections.add("Fours"))
            return "Fours";
        else if (countMap.containsKey(3) && sections.add("Threes"))
            return "Threes";
        else if (countMap.containsKey(2) && sections.add("Twos"))
            return "Twos";
        else if (countMap.containsKey(1) && sections.add("Aces"))
            return "Aces";
        else if (sections.add("Chance"))
            return "Chance";
        else
            return "Points Already Marked";
    }
}