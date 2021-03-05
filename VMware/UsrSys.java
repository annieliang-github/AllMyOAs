package edu.illinois.cs;

import java.util.HashMap;
import java.util.List;

public class UsrSys {

    public static String[] getUsr(List<String> names) {
        String[] res = new String[names.size()];
        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (count.containsKey(name)) {
                res[i] = name + count.get(name);
                count.put(name, count.get(name) + 1);
            } else {
                res[i] = name;
                count.put(name, 1);
            }
        }
        return res;
    }
}
