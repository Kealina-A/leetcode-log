package week5.I606ContructStringFromBinaryTree;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    StringBuilder res =  new StringBuilder();
    public String tree2str(TreeNode t) {
        dfs(t);
        return res.toString();
    }

    public void dfs(TreeNode t) {
        if (null==t.left &&null==t.right) {
            res.append(t.val);
            return;
        }
        res.append(t.val).append("(");
        if (null != t.left) {
            dfs(t.left);
        }
        res.append(t.val).append(")");

        if (null!=t.right) {
            res.append("(");
            dfs(t.right);
            res.append(")");
        }
    }


}
