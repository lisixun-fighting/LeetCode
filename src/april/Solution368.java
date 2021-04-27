package april;

import org.junit.Test;

import java.util.*;

public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        PriorityQueue<LinkedList<Integer>> queue = new PriorityQueue<>(
                (List<Integer> l1, List<Integer> l2) -> l2.size() - l1.size());
        for (int num : nums) {
            LinkedList<Integer> tmp = findSubset(num, queue);
            if(tmp == null)
                queue.offer(new LinkedList<>(List.of(num)));
            else {
                LinkedList<Integer> newList = new LinkedList<>(tmp);
                newList.add(num);
                queue.offer(newList);
            }
        }
        System.out.println(queue);
        return queue.peek();
    }

    private LinkedList<Integer> findSubset(int num, PriorityQueue<LinkedList<Integer>> queue) {
        Stack<LinkedList<Integer>> stack = new Stack<>();
        while (!queue.isEmpty()) {
            LinkedList<Integer> polled = queue.poll();
            stack.push(polled);
            if (num % polled.getLast() == 0) {
                while (!stack.empty())
                    queue.offer(stack.pop());
                return polled;
            }
        }
        while (!stack.empty())
            queue.offer(stack.pop());
        return null;
    }

    @Test
    public void test() {
        List<Integer> list = largestDivisibleSubset(new int[]{2, 4, 6, 9, 19, 81, 729});
        System.out.println(list);    }
}
