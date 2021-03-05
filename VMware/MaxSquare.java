package edu.illinois.cs;

public class MaxSquare {

    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            if (matrix[r][cols - 1] == '1') {
                dp[r][cols - 1] = 1;
                maxSide = 1;
            }
        }
        for (int c = 0; c < cols; c++) {
            if (matrix[rows - 1][c] == '1') {
                dp[rows - 1][c] = 1;
                maxSide = 1;
            }
        }
        for (int r = rows - 2; r >= 0; r--) {
            for (int c = cols - 2; c >= 0; c--) {
                if (matrix[r][c] == '1') {
                    dp[r][c] = 1 + Math.min(dp[r + 1][c + 1],
                            Math.min(dp[r + 1][c], dp[r][c + 1]));
                    maxSide = Math.max(maxSide, dp[r][c]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
