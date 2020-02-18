package week9.M24SwapNodesInPairs;

/**
 * ******************************************************************
 * Date: 2020/2/12  Wed
 * ******************************************************************
 * Title:   [24]两两交换链表中的节点
 * //给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * //
 * // 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * //
 * // 示例:
 * //
 * // 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * //
 * // Related Topics 链表
 * ******************************************************************
 * 执行耗时: 0ms,击败了 100.00% 的Java用户
 * 内存消耗: 34.5MB,击败了 20.75% 的Java用户
 * ******************************************************************
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }

    public static void main (String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Solution solution = new Solution();
        solution.swapPairs(l1);
    }

    public ListNode swapPairs (ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode firstNode = head;
        ListNode scondNode = head.next;
        firstNode.next = swapPairs(scondNode.next);
        scondNode.next = firstNode;
        return scondNode;
    }
}
