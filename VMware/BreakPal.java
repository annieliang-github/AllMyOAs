package edu.illinois.cs;

public class BreakPal {

    public static String change(String s) {
        int l = s.length();
        for (int i = 0; i <= l / 2; i++) {
            if (s.charAt(i) != 'a') {
                s = s.substring(0, i) + 'a' + s.substring(i + 1);
                break;
            }
        }
        if (isPal(s)) {
            return "IMPOSSIBLE";
        }
        return s;
    }

    private static boolean isPal(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
