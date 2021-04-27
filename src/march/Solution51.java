package march;

import org.junit.Test;

import java.util.*;

public class Solution51 {

    List<List<String>> res = null;

    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        int[][] flags = new int[n][n];
        dps(flags, 0);
        return res;
    }

    private void dps(int[][] flags, int n) {

        if(n == flags.length) {
            List<String> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(flags[i][j] == 1 ? "Q" : ".");
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        Queue<Integer> l1 = new LinkedList<>();
        Queue<Integer> l2 = new LinkedList<>();
        for (int i = 0; i < flags.length; i++) {
            if(flags[n][i] == 0) {
                flags[n][i] = 1;
                for (int j = n+1; j < flags.length; j++) {
                    if(i+j-n < flags.length && flags[j][i+j-n] == 0) {
                        flags[j][i+j-n] = 2;
                        l1.add(j);
                        l2.add(i+j-n);
                    }
                    if(i-j+n >= 0 && flags[j][i-j+n] == 0) {
                        flags[j][i-j+n] = 2;
                        l1.add(j);
                        l2.add(i-j+n);
                    }
                    if(flags[j][i] == 0) {
                        flags[j][i] = 2;
                        l1.add(j);
                        l2.add(i);
                    }
                }
                dps(flags, n+1);
                flags[n][i] = 0;
                while(!l1.isEmpty() && !l2.isEmpty()) {
                    flags[l1.poll()][l2.poll()] = 0;
                }
            }
        }
    }

    @Test
    public void test() {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }
}
