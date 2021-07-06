package july;

import org.junit.Test;

import java.util.Stack;

public class Solution255 {
    public boolean verifyPreorder(int[] preorder) {
        int right = preorder.length;
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] > preorder[0]) {
                right = i;
                break;
            }
        }
        return verifyPreorder(preorder, 1, right, -1, preorder[0])
                && verifyPreorder(preorder, right, preorder.length, preorder[0], Integer.MAX_VALUE);
    }

    private boolean verifyPreorder(int[] preorder, int begin, int end, int min, int max) {
        System.out.println(begin + " - " + end);
        if (begin >= end) {
            return true;
        }
        int med = end;
        for (int i = begin+1; i < end; i++) {
            if (preorder[i] > preorder[begin] && med == end) {
                med = i;
            }
            if (preorder[i] <= min || preorder[i] >= max) {
                return false;
            }
        }
//        System.out.println(begin + " - " + end + " " + med);
//        System.out.println();
        return verifyPreorder(preorder, begin+1, med, min, preorder[begin])
                && verifyPreorder(preorder, med, end, preorder[begin], max);
    }

    @Test
    public void test() {
        int[] preorder = {5,2,1,3,6,7};
        boolean res = verifyPreorder(preorder);
        System.out.println(res);
    }
}
