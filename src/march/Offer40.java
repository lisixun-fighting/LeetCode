package march;

import java.util.PriorityQueue;

public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1,o2) -> {
            if(o1 > o2) return -1;
            if(o1 == o2) return 0;
            return 1;
        });
        for (int j : arr) {
            if (queue.size() >= k && !queue.isEmpty() && j < queue.peek()) {
                queue.poll();
                queue.offer(j);
            }
            if (queue.size() < k)
                queue.offer(j);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
