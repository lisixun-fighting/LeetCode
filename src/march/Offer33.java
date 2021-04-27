package march;

public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        boolean flag = false;
        int left = -1;
        for (int i = 0; i < len; i++) {
            if(postorder[i] > postorder[len-1] && !flag) {
                left = i-1;
                flag = true;
            }
            if(postorder[i] < postorder[len-1] && flag) {
                return false;
            }
        }
        return verifyPostorder(0, left, postorder)
                && verifyPostorder(left+1, len-2, postorder);
    }

    public boolean verifyPostorder(int start, int end, int[] postorder) {
        if(start >= end) return true;
        int left = start-1;
        boolean flag = false;
        for (int i = start; i < end+1; i++) {
            if(postorder[i] > postorder[end] && !flag) {
                left = i-1;
                flag = true;
            }
            if(postorder[i] < postorder[end] && flag) {
                return false;
            }
        }
        return verifyPostorder(start, left, postorder)
                && verifyPostorder(left+1, end-1, postorder);
    }
}
