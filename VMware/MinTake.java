package edu.illinois.cs;

import java.util.Arrays;

public class MinTake {

    public static int take(double[] items) {
        Arrays.sort(items);
        int count = 0;
        int lo = 0;
        int hi = items.length - 1;
        while (lo < hi) {
            if (items[lo] + items[hi] <= 3.0) {
                lo++;
                hi--;
                count++;
            } else {
                hi--;
                count++;
            }
        }
        return count;
    }
}
