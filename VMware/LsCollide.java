package edu.illinois.cs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LsCollide {

    public static int collide(int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>
                (Comparator.reverseOrder());
        for (int i : arr) {
            q.add(i);
        }
        while (q.size() > 1) {
            int i1 = q.remove();
            int i2 = q.remove();
            if (i1 != i2) {
                q.add(i1 - i2);
            }
        }
        if (q.size() == 1) {
            return q.peek();
        }
        return 0;
    }
}
