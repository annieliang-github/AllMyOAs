package edu.illinois.cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
//            char[] chars = s.toCharArray();
//            Arrays.sort(chars);
//            String charStr = Arrays.toString(chars);
            String charStr = encode(s);
            if (!map.containsKey(charStr)) {
                map.put(charStr, new ArrayList<>());
            }
            map.get(charStr).add(s);
        }
        return new ArrayList<>(map.values());
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
