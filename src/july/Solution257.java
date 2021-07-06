package july;

import utils.TreeNode;

import java.util.*;

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(root.val);
        List<String> res = new LinkedList<>();
        binaryTreePaths(root, res, q);
        return res;
    }

    public void binaryTreePaths(TreeNode root, List<String> list, LinkedList<Integer> q) {
        if (root == null) {
            StringBuilder sb = new StringBuilder();
            for (Integer v : q) {
                sb.append(v);
                sb.append("->");
            }
            list.add(sb.substring(0, sb.length() - 2));
            return;
        }
        if (root.left != null) {
            q.addLast(root.left.val);
            binaryTreePaths(root.left, list, q);
            q.removeLast();
        }
        if (root.right != null) {
            q.addLast(root.right.val);
            binaryTreePaths(root.right, list, q);
            q.removeLast();
        }
    }
}
