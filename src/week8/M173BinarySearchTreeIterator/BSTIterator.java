package week8.M173BinarySearchTreeIterator;

import java.util.Stack;

/**
 * ******************************************************************
 * 日 期: 2020-02-01  星期六
 * ******************************************************************
 * 题 目:   [173]Binary Search Tree Iterator
 * //实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * //
 * // 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * //
 * // 示例：
 * //
 * // BSTIterator iterator = new BSTIterator(root);
 * //iterator.next();    // 返回 3
 * //iterator.next();    // 返回 7
 * //iterator.hasNext(); // 返回 true
 * //iterator.next();    // 返回 9
 * //iterator.hasNext(); // 返回 true
 * //iterator.next();    // 返回 15
 * //iterator.hasNext(); // 返回 true
 * //iterator.next();    // 返回 20
 * //iterator.hasNext(); // 返回 false
 * //
 * // 提示：
 * //
 * // next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * // 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 * //
 * // Related Topics 栈 树 设计
 * ******************************************************************
 * 执行耗时: 23ms,击败了 85.04% 的Java用户
 * 内存消耗: 50.4MB,击败了 31.7% 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class BSTIterator {

    private Stack<Integer> stack = new Stack<>();

    public BSTIterator (TreeNode root) {
        dfs(root);
    }

    public void dfs (TreeNode root) {
        if (null == root) return;
        dfs(root.right);
        stack.push(root.val);
        dfs(root.left);
    }

    /**
     * @return the next smallest number
     */
    public int next () {
        return stack.pop();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext () {
        return ! stack.isEmpty();
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
