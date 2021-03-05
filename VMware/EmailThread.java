package edu.illinois.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EmailThread {

    public static List<int[]> getThreads(List<String> strs) {
        HashMap<String, int[]> db = new HashMap<>();
        int tid = 0;
        ArrayList<int[]> res = new ArrayList<>();
        for (String s : strs) {
            String[] split = s.split(",");
            String send = split[0];
            String get = split[1];
            String[] contents = split[2].split("---");
            int len = contents.length;
            String encode = send + "," + get + Arrays.toString(contents);
            if (len == 1) {
                tid++;
                int[] init = new int[]{tid, 1};
                db.put(encode, init);
                res.add(init);
            } else {
                String[] pre = new String[len - 1];
                System.arraycopy(contents, 1, pre, 0, len - 1);
                int[] last = db.get(get + "," + send + Arrays.toString(pre));
                int[] up = new int[]{last[0], last[1] + 1};
                db.put(encode, up);
                res.add(up);
            }
        }
        return res;
    }
}
