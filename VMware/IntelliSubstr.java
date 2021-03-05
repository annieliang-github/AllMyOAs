package edu.illinois.cs;

import java.util.List;
import java.util.stream.Collectors;

public class IntelliSubstr {

    public static int get(String s, int k, String dict) {
        List<Boolean> norm = s.chars()
                .mapToObj(i -> dict.charAt(i - 'a') == '0')
                .collect(Collectors.toList());
        int res = 0;
        int lo = 0;
        int hi = 0;
        int count = 0;
        while (hi < s.length()) {
            if (norm.get(hi)) {
                count++;
            }
            hi++;
            while (lo < hi && count > k) {
                if (norm.get(lo)) {
                    count--;
                }
                lo++;
            }
            if (count <= k) {
                res = Math.max(res, hi - lo);
            }
        }
        return res;
    }
}
