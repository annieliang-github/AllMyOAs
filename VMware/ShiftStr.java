package edu.illinois.cs;

public class ShiftStr {

    public static String shift(String str, int left, int right) {
        int n = str.length();
        left = left % n;
        right = right % n;
        if (left == right) {
            return str;
        }
        if (left > right) {
            int shift = left - right;
            String shifted = str.substring(0, shift);
            str = str.substring(shift) + shifted;
            return str;
        }
        int shift = right - left;
        String shifted = str.substring(n - shift);
        str = shifted + str.substring(0, n - shift);
        return str;
    }
}
