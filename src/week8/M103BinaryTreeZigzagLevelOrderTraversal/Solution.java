package week8.M103BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ******************************************************************
 * 日 期: 2020-01-31  星期五
 * ******************************************************************
 * 题 目:   [103]Binary Tree Zigzag Level Order Traversal
 * //给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * //
 * // 例如：
 * //给定二叉树 [3,9,20,null,null,15,7],
 * //
 * //     3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 * //
 * //
 * // 返回锯齿形层次遍历如下：
 * //
 * // [
 * //  [3],
 * //  [20,9],
 * //  [15,7]
 * //]
 * //
 * // Related Topics 栈 树 广度优先搜索
 * ******************************************************************
 * 执行耗时: 1ms,击败了 99.13% 的Java用户
 * 内存消耗: 36.2MB,击败了 41.9% 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder (TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> evenStack = new Stack<>();
        Stack<TreeNode> oddStack = new Stack<>();
        if (null == root) return res;
        evenStack.push(root);
        int count = 1;
        while (! evenStack.isEmpty() || ! oddStack.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            if (count % 2 == 0) {
                while (! oddStack.isEmpty()) {
                    TreeNode pop = oddStack.pop();
                    tmp.add(pop.val);
                    if (null != pop.right) evenStack.push(pop.right);
                    if (null != pop.left) evenStack.push(pop.left);
                }
            } else {
                while (! evenStack.isEmpty()) {
                    TreeNode pop = evenStack.pop();
                    tmp.add(pop.val);
                    if (null != pop.left) oddStack.push(pop.left);
                    if (null != pop.right) oddStack.push(pop.right);
                }
            }
            res.add(tmp);
            count++;
        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }
}
