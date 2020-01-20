package week5.I108ConvertSortedArrayToBinarySearchTree;

public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        int[] nums = {-10,-3,0,5,9};
        solution.sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST (int[] nums) {
        if (nums == null) {
            return null;
        }
        return dfs(0,nums.length,nums);
    }

    public TreeNode dfs (int start, int end, int[] nums) {
        if (start == end) return null;
        int midIndex =(start+end)/2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = dfs(start,midIndex,nums);
        root.right = dfs(midIndex+1,end,nums);
        return root;
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
