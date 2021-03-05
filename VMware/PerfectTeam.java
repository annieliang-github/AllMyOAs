package edu.illinois.cs;

import java.util.Comparator;
import java.util.HashMap;

public class PerfectTeam {

    public static int diffTeams(String skills) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : skills.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        return count.values().stream().min(Comparator.naturalOrder()).orElse(0);
    }
}
