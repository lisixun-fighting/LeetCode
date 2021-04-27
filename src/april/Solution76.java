package april;

import org.junit.Test;

import java.util.*;

public class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.merge(t.charAt(i), 1, Integer::sum);
            map.put(t.charAt(i), new LinkedList<>());
        }

        TreeSet<Integer> seq = new TreeSet<>();
        int[] res = {0, s.length()};

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Queue<Integer> queue = map.get(ch);
            int del = -1;
            if(queue != null) {
                queue.offer(i);
                seq.add(i);
                while (queue.size() > need.get(ch)) {
                    del = queue.poll();
                    seq.remove(del);
                }
            }
            if(seq.size() == t.length() && seq.last() - seq.first() < res[1] - res[0]) {
                res[0] = seq.first();
                res[1] = seq.last();
            }
        }
        if(res[1] == s.length()) return "";
        return s.substring(res[0], res[1]+1);
    }

    @Test
    public void test() {
        String s = "A";
        String t = "A";
        Solution76 sol = new Solution76();
        System.out.println(sol.minWindow(s, t));
    }
}
