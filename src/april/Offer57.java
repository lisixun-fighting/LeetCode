package april;

import org.junit.Test;

import java.util.*;

public class Offer57 {
    public int[][] findContinuousSequence(int target) {
        int left = 0;
        int right = 1;
        int sum = left + right;
        List<int[]> res = new ArrayList<>();
        while (left < right) {
            if(sum < target) {
                sum += ++right;
            }
            else if(sum > target)
                sum -= left++;
            else {
                int[] arr = new int[right-left+1];
                for (int i = left; i <= right; i++) {
                    arr[i-left] = i;
                }
                res.add(arr);
                sum += ++right;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    @Test
    public void test() {
        int[][] res = findContinuousSequence(9);
        System.out.println(Arrays.deepToString(res));
    }
}
