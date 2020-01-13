package week5.I257BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    public static void main (String[] args) {
//        Solution solution = new Solution();
//        solution.binaryTreePaths();
    }
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths (TreeNode root) {
        dfs("",root);
        return res;
    }

    public void dfs (String stringBuffer,TreeNode node) {
        if (null==node) {
            return;
        }
        if (null == node.left && null == node.right) {
            res.add(stringBuffer+node.val);
            return;
        }
        dfs(stringBuffer+node.val+"->",node.left);
        dfs(stringBuffer+node.val+"->",node.right);
    }
}
