package week5.I101_SymmetricTree;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return dfs(root.left,root.right);
    }

    public boolean dfs (TreeNode left,TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val==right.val) && dfs(left.left,right.right) && dfs(left.right,right.left);
    }
}
