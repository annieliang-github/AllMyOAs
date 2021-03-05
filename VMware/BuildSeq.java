package edu.illinois.cs;

import java.util.Arrays;

public class BuildSeq {

    public static String[] build(String str) {
        int len = str.length();
        if (len == 0) {
            return new String[]{};
        }
        String[] res = new String[(int) (Math.pow(2, len) - 1)];
        String[] nex = build(str.substring(1));
        System.arraycopy(nex, 0, res, 0, nex.length);
        res[nex.length] = String.valueOf(str.charAt(0));
        for (int i = 0; i < nex.length; i++) {
            res[nex.length + i + 1] = str.charAt(0) + nex[i];
        }
        Arrays.sort(res);
        return res;
    }
}
