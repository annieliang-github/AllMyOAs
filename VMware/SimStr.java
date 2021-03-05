package edu.illinois.cs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SimStr {

    public static List<String> filter(String[] strs) {
        HashSet<String> seen = new HashSet<>();
        ArrayList<String> res = new ArrayList<>();
        for (String s : strs) {
            String encode = encode(s);
            if (!seen.contains(encode)) {
                seen.add(encode);
                res.add(s);
            }
        }
        return res;
    }

    private static String encode(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                sb.append('a' + i).append(count[i]);
            }
        }
        return sb.toString();
    }
}
