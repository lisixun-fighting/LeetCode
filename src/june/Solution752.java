package june;

import org.junit.Test;

import java.util.*;

/**
 * Question Description:
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 *
 * Solution:
 * Canonical Case of BFS
 * To save more spaces, I use Integer 0-9999 to represent different states of wheels.
 */
public class Solution752 {
    public int openLock(String[] deadends, String target) {
        int goal = string2Num(target);
        Set<Integer> deadSet = new HashSet<>();
        Set<Integer> dupSet = new HashSet<>();
        for (String s : deadends) {
            deadSet.add(string2Num(s));
        }
        Queue<Integer> queue = new LinkedList<>();

        // two special cases
        if (!deadSet.contains(0))
            queue.add(0);
        if (goal == 0)
            return 0;

        // begin BFS
        int size;
        int step = 0;
        while ((size = queue.size()) > 0) {
            step++;
            for (int i = 0; i < size; i++) {
                int last = queue.remove();
                System.out.println(last);
                int j = 1;
                for (; j <= 1000; j *= 10) {
                    if(update(last, j, queue, deadSet, goal, dupSet, true))
                        return step;
                    if(update(last, j, queue, deadSet, goal, dupSet, false))
                        return step;
                }
            }
        }
        return -1;
    }

    private boolean update(int last, int unit, Queue<Integer> queue, Set<Integer> deadSet,
                           int goal, Set<Integer> dupSet, boolean symbol) {
        last = circulate(last, unit, symbol);

        if (last == goal)
            return true;
        if (deadSet.contains(last) || !dupSet.add(last))
            return false;
        queue.add(last);
        return false;
    }

    /**
     * Switch states of Wheels
     * @param last last state
     * @param unit wheel to change range from 1 to 1000
     * @param symbol to add or subtract
     * @return new state
     */
    private int circulate(int last, int unit, boolean symbol) {
        int a = (last % (unit * 10)) / unit;
        last -= (a * unit);
        a += (symbol ? 1 : -1);
        if (a == 10) a = 0; // '9' -> '0'
        else if (a == -1) a = 9; // '0' -> '9'
        last += (a * unit);
        return last;
    }

    /**
     * Switch string pattern to Integer
     * @param target origin string
     * @return int pattern
     */
    private int string2Num(String target) {
        int a = 0;
        for (int i = 0; i < 4; i++) {
            a *= 10;
            a += (target.charAt(i) - '0');
        }
        return a;
    }

    @Test
    public void test() {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        int res = openLock(deadends, "0202");
        System.out.println(res);
    }

    @Test
    public void testCirc() {
        int res = circulate(9999, 1000, true);
        System.out.println(res);
    }
}
