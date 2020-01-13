package week5.I637AverageOfLevelsInBinaryTree;

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

    public List<Double> averageOfLevels (TreeNode root) {
        if (root==null) return new ArrayList<>();
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            double len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                if (null!=node.left) queue.add(node.left);
                if (null!=node.right) queue.add(node.right);
            }
            res.add(sum/len);
        }
        return res;
    }
}
