package week5.I104_MaximumDepthOfBinaryTree;

public class Solution {


    public int maxDepth (TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }
}
