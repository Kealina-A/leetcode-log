package week8.M94BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * ******************************************************************
 * 日 期: 2020-01-31  星期五
 * ******************************************************************
 * 题 目:   [94]Binary Tree Inorder Traversal
 * <p>
 * //给定一个二叉树，返回它的中序 遍历。
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
 * //输出: [1,3,2]
 * //
 * // 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * // Related Topics 栈 树 哈希表
 * ******************************************************************
 * 执行耗时: 0ms,击败了 100% 的Java用户
 * 内存消耗: 34.4MB,击败了 96/06% 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class Solution {
    List<Integer> stack = new ArrayList<>();

    public List<Integer> inorderTraversal (TreeNode root) {
        if (root == null) return stack;
        inorderTraversal(root.left);
        stack.add(root.val);
        inorderTraversal(root.right);
        return stack;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }
}


