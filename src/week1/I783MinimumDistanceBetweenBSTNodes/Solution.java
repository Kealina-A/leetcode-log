package week1.I783MinimumDistanceBetweenBSTNodes;

import javax.swing.tree.TreeNode;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    Integer min = Integer.MAX_VALUE, pre = null;

    public int minDiffInBST (TreeNode root) {
        if (root == null) return 0;
        minDiffInBST(root.left);
        if (pre != null) min = Math.min(min, root.val - pre);
        pre = root.val;
        minDiffInBST(root.right);
        return min;
    }
}
