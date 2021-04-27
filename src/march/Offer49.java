package march;

public class Offer49 {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            uglyNums[i] = Math.min(uglyNums[p2]*2, Math.min(uglyNums[p3]*3, uglyNums[p5]*5));
            while(uglyNums[p2]*2 < uglyNums[i]) p2++;
            while(uglyNums[p3]*3 < uglyNums[i]) p3++;
            while(uglyNums[p5]*5 < uglyNums[i]) p5++;
        }
        return uglyNums[n-1];
    }
}
