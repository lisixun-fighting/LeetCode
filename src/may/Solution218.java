package may;

import org.junit.Test;

import java.util.*;

public class Solution218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(0, 0);
        Map<Integer, Set<Integer>> leftHeight = new HashMap<>();
        Map<Integer, Set<Integer>> rightHeight = new HashMap<>();
        TreeSet<Integer> list = new TreeSet<>();
        for (int[] building : buildings) {
            list.add(building[0]);
            list.add(building[1]);
            leftHeight.computeIfAbsent(building[0], k -> new HashSet<>());
            leftHeight.get(building[0]).add(building[2]);

            rightHeight.computeIfAbsent(building[1], k -> new HashSet<>());
            rightHeight.get(building[1]).add(building[2]);
        }
        System.out.println(leftHeight);
        for (Integer point : list) {
            int height = queue.lastKey();

            if (rightHeight.get(point) != null)
                for (Integer right : rightHeight.get(point))
                    if (right != null && queue.get(right) != null)
                        if (queue.get(right) == 0)
                            queue.remove(right);
                        else
                            queue.put(right, queue.get(right)-1);
            if (leftHeight.get(point) != null)
                for (Integer left : leftHeight.get(point))
                    if (left != null)
                        if (queue.get(left) == null)
                            queue.put(left, 0);
                        else
                            queue.put(left, queue.get(left)+1);

            if (queue.lastKey() != height) {
                res.add(List.of(point, queue.lastKey()));
            }
        }
        return res;
    }

    @Test
    public void test() {
        TreeSet<Integer> queue = new TreeSet<>();

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            queue.add(random.nextInt(10));
        }
        queue.forEach(System.out::print);

    }
}
