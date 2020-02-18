package week9.M19RemoveNthNodeFromEndOfList;

/**
 * ******************************************************************
 * Date: 2020/2/13  Thu
 * ******************************************************************
 * Title:   [19]删除链表的倒数第N个节点
 * //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * //
 * // 示例：
 * //
 * // 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * //
 * //当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * //
 * //
 * // 说明：
 * //
 * // 给定的 n 保证是有效的。
 * //
 * // 进阶：
 * //
 * // 你能尝试使用一趟扫描实现吗？
 * // Related Topics 链表 双指针
 * ******************************************************************
 * 执行耗时: 0ms,击败了 100.00% 的Java用户
 * 内存消耗: 40.5MB,击败了 5.01% 的Java用户
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

    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode back = dummy;
        ListNode pre = dummy;
        for (int i = 0; i <= n; i++) {
            back = back.next;
        }

        while (back != null) {
            back = back.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
