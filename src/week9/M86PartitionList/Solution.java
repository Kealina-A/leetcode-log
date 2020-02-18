package week9.M86PartitionList;


/**
 * ******************************************************************
 * Date: 2020/2/16  Sun
 * ******************************************************************
 * Title: [86] partition-list
 * //给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * //
 * // 你应当保留两个分区中每个节点的初始相对位置。
 * //
 * // 示例:
 * //
 * // 输入: head = 1->4->3->2->5->2, x = 3
 * //输出: 1->2->2->4->3->5
 * //
 * // Related Topics 链表 双指针
 * ******************************************************************
 * 执行耗时: 0ms,击败了 100.00% 的Java用户
 * 内存消耗: 40.9MB,击败了 5.11% 的Java用户
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
        ListNode listNode = array2ListNode(new int[]{1, 4, 3, 2, 5, 2});
        Solution solution = new Solution();
        solution.partition(listNode, 3);
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

    public ListNode partition (ListNode head, int x) {
        ListNode slowHead = new ListNode(0);
        ListNode slow = slowHead;
        ListNode fastHead = new ListNode(0);
        ListNode fast = fastHead;

        while (head != null) {
            if (head.val < x) {
                slow.next = head;
                slow = slow.next;
            } else {
                fast.next = head;
                fast = fast.next;
            }
            head = head.next;
        }
        fast.next = null;
        slow.next = fastHead.next;
        return slowHead.next;
    }


}
