package week9.E83RemoveDuplicatesFromSortedList;


/**
 * ******************************************************************
 * Date: 2020/2/16  Sun
 * ******************************************************************
 * Title: [83] Remove Duplicates From Sorted List
 * ******************************************************************
 * Runtime:1 ms, faster than 98.49% of Java online submissions.
 * Memory Usage:35.8 MB, less than 99.62% of Java online submissions.
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
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                cur.next.next = temp.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
