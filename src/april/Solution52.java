package april;

import java.util.*;

public class Solution52 {

    int res;

    public int totalNQueens(int n) {

        res = 0;
        int[][] flags = new int[n][n];
        dps(flags, 0);
        return res;
    }

    private void dps(int[][] flags, int n) {

        if(n == flags.length) {
            res++;
            return;
        }

        Deque<Integer> l = new LinkedList<>();

        for (int i = 0; i < flags.length; i++) {
            if(flags[n][i] == 0) {
                flags[n][i] = 1;
                for (int j = n+1; j < flags.length; j++) {
                    if(i+j-n < flags.length && flags[j][i+j-n] == 0) {
                        flags[j][i+j-n] = 2;
                        l.addFirst(j);
                        l.addLast(i+j-n);
                    }
                    if(i-j+n >= 0 && flags[j][i-j+n] == 0) {
                        flags[j][i-j+n] = 2;
                        l.addFirst(j);
                        l.addLast(i-j+n);
                    }
                    if(flags[j][i] == 0) {
                        flags[j][i] = 2;
                        l.addFirst(j);
                        l.addLast(i);
                    }
                }
                dps(flags, n+1);
                flags[n][i] = 0;
                while(!l.isEmpty()) {
                    flags[l.removeFirst()][l.removeLast()] = 0;
                }
            }
        }
    }
}
