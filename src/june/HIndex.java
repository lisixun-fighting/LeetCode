package june;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class HIndex {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        int res = 0;

        for (int i = citations.length-1; i >= 0; i--) {
            if ((citations.length - i) >= citations[i]) {
                res = Math.max(res, citations[i]);
            } else {
                res = Math.max(res, citations.length - i);
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] citations = {1,3,4,52,52,1,6};
        int res = hIndex(citations);
        System.out.println(res);
    }
}
