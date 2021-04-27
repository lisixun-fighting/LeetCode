package march;

import java.util.*;
import utils.TreeNode;

public class Solution199 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if(root != null) {
            res.add(root.val);
            dps(root.right, 2);
            dps(root.left, 2);
        }
        return res;
    }

    private void dps(TreeNode root, int depth) {
        if(root != null) {
            if(depth > res.size()) res.add(root.val);
            dps(root.right, depth+1);
            dps(root.left, depth+1);
        }
    }
}
