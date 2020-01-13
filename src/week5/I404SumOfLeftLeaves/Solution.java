package week5.I404SumOfLeftLeaves;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {

        if (root==null) return 0;
        if (root.left==null && root.right==null) return 0;
        sum+=sumOfLeftLeaves(root.left);
        return sum;
    }

    public void dfs(TreeNode node) {
        if (null == node) return;

        dfs(node.left);
        dfs(node.right);
    }


}
