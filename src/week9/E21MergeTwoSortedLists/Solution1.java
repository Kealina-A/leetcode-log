package week9.E21MergeTwoSortedLists;

/**
 * ******************************************************************
 * Date: 2020/2/12  Wed
 * ******************************************************************
 * Title:   [21]合并两个有序链表
 * //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * //
 * // 示例：
 * //
 * // 输入：1->2->4, 1->3->4
 * //输出：1->1->2->3->4->4
 * //
 * // Related Topics 链表
 * ******************************************************************
 * 执行耗时: ms,击败了 % 的Java用户
 * 内存消耗: MB,击败了 % 的Java用户
 * ******************************************************************
 */
public class Solution1 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }

    public static void main (String[] args) {
        ListNode listNodeA = new ListNode(1);
        ListNode listNodeB = new ListNode(2);
        ListNode listNodeC = new ListNode(1);
        ListNode listNodeD = new ListNode(3);
        listNodeA.next = listNodeB;
        listNodeC.next = listNodeD;
        Solution1 solution11 = new Solution1();
        solution11.mergeTwoLists(listNodeA, listNodeC);
    }

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode preHead = new ListNode(- 1);
        ListNode preNode = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                preNode.next = l1;
                l1 = l1.next;
            } else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        preNode.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
