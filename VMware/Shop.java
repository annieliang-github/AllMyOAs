package edu.illinois.cs;

public class Shop {

    public static int shop(int budget, int[] nums, int[] prices) {
        int n = nums.length;
        // dp[i]: max num books if i have budge i
        int[] dp = new int[budget + 1];
        for (int b = 1; b <= budget; b++) {
            for (int i = 0; i < n; i++) {
                if (prices[i] <= b) {
                    dp[b] = Math.max(dp[b], dp[b - prices[i]] + nums[i]);
                }
            }
        }
        return dp[budget];
    }
}
