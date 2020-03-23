package doitevery.E876_20200323;

/**
 * ******************************************************************
 * Date: 2020/3/23  Mon
 * ******************************************************************
 * Title:
 * ******************************************************************
 * Success:
 * Runtime: ms, faster than % of Java online submissions.
 * Memory Usage: MB, less than % of Java online submissions.
 * ******************************************************************
 */
class ListNode {
    int val;
    ListNode next;

    ListNode (int x) {
        val = x;
    }
}

public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        solution.middleNode(listNode1);
    }

    public ListNode middleNode (ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        int count1 = - 1;
        while (start != null) {
            start = start.next;
            count1++;
        }

        count1 = count1 / 2;
        int count2 = 0;
        while (count2 < count1) {
            head = head.next;
            count2++;
        }
        return head;
    }
}
