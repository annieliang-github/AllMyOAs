package edu.illinois.cs;

public class EvenSubarr {

    public static int count(int[] arr, int k) {
        int n = arr.length;
        int validCount = 0;
        for (int i = 0; i < n; i++) {
            int[] dp = new int[n];
            if (isOdd(arr[i])) {
                dp[i] = 1;
            }
            if (dp[i] <= k) {
                validCount++;
            }
            for (int j = i + 1; j < n; j++) {
                dp[j] = dp[j - 1];
                if (isOdd(arr[j])) {
                    dp[j]++;
                }
                if (dp[j] <= k) {
                    validCount++;
                }
            }
        }
        return validCount;
    }

    private static boolean isOdd(int i) {
        return i % 2 == 1;
    }
}
