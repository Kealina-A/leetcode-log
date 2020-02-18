package week9.H25ReverseNodesInKGroup;

/**
 * ******************************************************************
 * Date: 2020/2/12  Wed
 * ******************************************************************
 * Title:   [25]K 个一组翻转链表
 * //给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * //
 * // k 是一个正整数，它的值小于或等于链表的长度。
 * //
 * // 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * //
 * // 示例 :
 * //
 * // 给定这个链表：1->2->3->4->5
 * //
 * // 当 k = 2 时，应当返回: 2->1->4->3->5
 * //
 * // 当 k = 3 时，应当返回: 3->2->1->4->5
 * //
 * // 说明 :
 * //
 * //
 * // 你的算法只能使用常数的额外空间。
 * // 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * //
 * // Related Topics 链表
 * ******************************************************************
 * 执行耗时: 0ms,击败了 100.00% 的Java用户
 * 内存消耗:45.6 MB,击败了 5.12% 的Java用户
 * ******************************************************************
 * 递归解法
 * ******************************************************************
 */
public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null) return null;
        ListNode cur = head, tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) return head;
            tail = tail.next;
        }

        ListNode newHead = reverse(cur, tail);
        cur.next = reverseKGroup(tail, k);
        return newHead;
    }

    public ListNode reverse (ListNode start, ListNode end) {
        ListNode pre = null, cur = start, nxt = start;
        while (cur != end) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
