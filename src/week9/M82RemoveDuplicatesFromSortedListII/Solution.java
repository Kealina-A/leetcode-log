package week9.M82RemoveDuplicatesFromSortedListII;

import java.util.HashMap;
import java.util.Map;

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
 * 执行耗时: 6ms,击败了 5.86% 的Java用户
 * 内存消耗: 45MB,击败了 5.03 % 的Java用户
 * ******************************************************************
 * 统计每个元素出现的个数，如果大于1的直接删除
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
        ListNode listNode = array2ListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        Solution solution = new Solution();
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
        if (head == null || head.next == null) return head;

        Map<Integer, Integer> memo = new HashMap<>();
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode scond = dummy.next;

        while (temp != null) {
            if (memo.get(temp.val) == null) {
                memo.put(temp.val, 1);
            } else {
                memo.put(temp.val, memo.get(temp.val) + 1);
            }
            temp = temp.next;
        }

        while (scond != null) {
            if (memo.get(scond.val) > 1) {
                first.next = scond.next;
                scond = scond.next;
            } else {
                scond = scond.next;
                first = first.next;
            }
        }
        return dummy.next;
    }
}
