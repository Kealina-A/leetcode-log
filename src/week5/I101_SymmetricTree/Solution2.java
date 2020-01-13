package week5.I101_SymmetricTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode l = q.poll();
            TreeNode r = q.poll();
            if (l==null && r==null) continue;
            if (l==null || r==null) return false;
            if (l.val!=r.val) return false;

            q.add(l.left);
            q.add(r.right);
            q.add(l.right);
            q.add(r.left);
        }
        return true;
    }

}
