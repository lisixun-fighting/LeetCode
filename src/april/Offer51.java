package april;

public class Offer51 {
    private static class TreeNode {
        int val;
        int copy = 1;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int put(TreeNode root, int num) {
        if(num == root.val) {
            root.copy++;
            return height(root.right);
        }
        if(num > root.val) {
            if(root.right == null) {
                root.right = new TreeNode(num);
                return height(root.right.right);
            }
            return put(root.right, num);
        }
        if(root.left == null) {
            root.left = new TreeNode(num);
            return root.copy + height(root.left.right);
        }
        return root.copy + put(root.left, num);
    }

    private int height(TreeNode root) {
        if(root == null) return 0;
        return height(root.left) + height(root.right) + root.copy;
    }

    public int reversePairs(int[] nums) {
        if(nums.length == 0)
            return 0;
        TreeNode root = new TreeNode(nums[0]);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res += put(root, nums[i]);
        }
        return res;
    }

}
