package contest.weekly178.M5346;

/**
 * ******************************************************************
 * Date: 2020/3/1  Sun
 * ******************************************************************
 * Title: [5346] linked-list-in-binary-tree
 * ******************************************************************
 * Success:
 * Runtime:2 ms, faster than 100.00% of Java online submissions.
 * Memory Usage:41.3 MB, less than 100.00% of Java online submissions.
 * ******************************************************************
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    public boolean isSubPath (ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean isSub (ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val != root.val) return false;
        return isSub(head.next, root.left) || isSub(head.next, root.right);
    }
}
