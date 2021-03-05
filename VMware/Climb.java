package edu.illinois.cs;

import java.util.Arrays;

public class Climb {

    public static int climb(int[] hs) {
        int[] neg = Arrays.stream(hs).map(i -> -i).toArray();
        return Math.min(help(hs), help(neg));
    }

    // non-decreasing
    private static int help(int[] hs) {
        int n = hs.length;
        int[] sort = new int[n];
        System.arraycopy(hs, 0, sort, 0, n);
        Arrays.sort(sort);
        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = Math.abs(hs[0] - sort[0]);
        for (int i = 2; i <= n; i++) {
            dp[1][i] = Math.min(dp[1][i - 1], Math.abs(hs[0] - sort[i - 1]));
        }
        for (int i = 2; i <= n; i++) {
            dp[i][1] = dp[i - 1][1] + Math.abs(hs[i - 1] - sort[0]);
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1],
                        dp[i - 1][j] + Math.abs(hs[i - 1] - sort[j - 1]));
            }
        }
        return dp[n][n];
    }
}
