package edu.illinois.cs;

import java.util.HashMap;

public class StrScore {

    public static String score(String s1, String s2) {
        HashMap<Character, Integer> count = new HashMap<>();
        count.put('E', 1);
        count.put('M', 3);
        count.put('H', 5);
        int score1 = s1.chars().map(i -> count.get((char) i)).sum();
        int score2 = s2.chars().map(i -> count.get((char) i)).sum();
        if (score1 > score2) {
            return s1;
        }
        if (score1 == score2) {
            return "TIE";
        }
        return s2;
    }
}
