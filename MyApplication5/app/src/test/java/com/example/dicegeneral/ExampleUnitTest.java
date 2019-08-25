package com.example.dicegeneral;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private List<Integer> list;
    private Set<String> sections;
    private Map<Integer, Integer> countMap;

    @Before
    public void setUp() {
        sections = new HashSet<>();

        list = new ArrayList<>();
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(5);
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {
        int result = getDicesThrowsResult((list));

        assertEquals(16, result);
    }

    private int getDicesThrowsResult(List<Integer> dices) {
        countMap = new HashMap<>();
        int sum = 0;

        for (Integer dice : dices) {
            if (countMap.containsKey(dice))
                countMap.put(dice, countMap.get(dice) + 1);
            else
                countMap.put(dice, 1);
        }

        if (countMap.containsValue(2) && countMap.containsValue(3)) {
            return 25;
        } else if (countMap.containsValue(5)) {
            return 50;
        } else if (countMap.containsValue(3) || countMap.containsValue(4)) {
            for (Integer d : dices)
                sum += d;
            return sum;
        } else if (countMap.containsValue(1)){
            if (countMap.containsKey(1))
                return 40;
            else
                return 30;
        } else {
            return 0;
        }
    }

    @Test
    public void testSections() {
        int var = getDicesThrowsResult(list);
        String result = getClassification(countMap);

        assertEquals("Three Of A Kind", result);
        assertEquals(16, var);

        String result2 = getClassification(countMap);

        assertEquals("Chance", result2);
    }

    private String getClassification(Map<Integer, Integer> countMap) {
        if (countMap.containsValue(2) && countMap.containsValue(3) && sections.add("Full House"))
            return "Full House";
        else if (countMap.containsValue(5) && sections.add("Yahtzee"))
            return "Yahtzee";
        else if (countMap.containsValue(3) && sections.add("Three Of A Kind"))
            return "Three Of A Kind";
        else if (countMap.containsValue(4) && sections.add("Four Of A Kind"))
            return "Four Of A Kind";
        else if (countMap.containsValue(1) && countMap.size() == 5) {
            if (countMap.containsKey(1))
                return "Small Straight";
            else
                return "Large Straight";
        } else
            return "Chance";
    }
}