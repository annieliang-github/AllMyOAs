package edu.illinois.cs;

import java.util.Arrays;

public class TeamForm2 {

    public static int numTeams(int[] skills, int k, int l, int r) {
        int n = (int) Arrays.stream(skills)
                .filter(i -> l <= i && i <= r).count();
        if (n < k) {
            return 0;
        }
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        int count = 0;
        for (int m = k; m <= n; m++) {
            count += fact[n] / (fact[m] * fact[n - m]);
        }
        return count;
    }
}
