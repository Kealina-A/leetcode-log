package week9.M82RemoveDuplicatesFromSortedListII;

/**
 * ******************************************************************
 * Date: 2020/2/15  Sat
 * ******************************************************************
 * Title:   [82]删除排序链表中的重复元素 II
 * //给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * //
 * // 示例 1:
 * //
 * // 输入: 1->2->3->3->4->4->5
 * //输出: 1->2->5
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: 1->1->1->2->3
 * //输出: 2->3
 * // Related Topics 链表
 * ******************************************************************
 * 执行耗时: 1ms,击败了 98.6% 的Java用户
 * 内存消耗: 36.2MB,击败了 91.66 % 的Java用户
 * ******************************************************************
 * 双指针
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
        ListNode listNode = array2ListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        Solution1 solution = new Solution1();
        solution.deleteDuplicates(listNode);
    }

    public static ListNode array2ListNode (int[] array) {
        ListNode listNode = new ListNode(0);
        ListNode temp = new ListNode(array[0]);
        listNode.next = temp;
        for (int i = 1; i < array.length; i++) {
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }
        return listNode.next;
    }

    public ListNode deleteDuplicates (ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
