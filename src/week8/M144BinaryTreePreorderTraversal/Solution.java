package week8.M144BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ******************************************************************
 * 日 期: 2020-02-01  星期六
 * ******************************************************************
 * 题 目:   [144]Binary Tree Preorder Traversal
 * //给定一个二叉树，返回它的 前序 遍历。
 * //
 * // 示例:
 * //
 * // 输入: [1,null,2,3]
 * //   1
 * //    \
 * //     2
 * //    /
 * //   3
 * //
 * //输出: [1,2,3]
 * //
 * //
 * // 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * // Related Topics 栈 树
 * ******************************************************************
 * 执行耗时: 1ms,击败了 64.99% 的Java用户
 * 内存消耗: 34.6MB,击败了 80.78% 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class Solution {

    public List<Integer> preorderTraversal (TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (null == root) return res;
        stack.push(root);
        while (! stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (null != pop.right) stack.push(pop.right);
            if (null != pop.left) stack.push(pop.left);
        }
        return res;
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
