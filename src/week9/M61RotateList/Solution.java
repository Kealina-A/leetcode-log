package week9.M61RotateList;

/**
 * ******************************************************************
 * Date: 2020/2/13  Thu
 * ******************************************************************
 * Title:   [61]旋转链表
 * //给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * //
 * // 示例 1:
 * //
 * // 输入: 1->2->3->4->5->NULL, k = 2
 * //输出: 4->5->1->2->3->NULL
 * //解释:
 * //向右旋转 1 步: 5->1->2->3->4->NULL
 * //向右旋转 2 步: 4->5->1->2->3->NULL
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: 0->1->2->NULL, k = 4
 * //输出: 2->0->1->NULL
 * //解释:
 * //向右旋转 1 步: 2->0->1->NULL
 * //向右旋转 2 步: 1->2->0->NULL
 * //向右旋转 3 步: 0->1->2->NULL
 * //向右旋转 4 步: 2->0->1->NULL
 * // Related Topics 链表 双指针
 * ******************************************************************
 * 执行耗时: 0ms,击败了 100.00% 的Java用户
 * 内存消耗: 41.2MB,击败了5.0 % 的Java用户
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
        l1.next = l2;
        Solution solution = new Solution();
        solution.rotateRight(l1, 2);
    }

    /**
     * 方法：1. 将最后一个与第一个连起来
     * 2. 找到倒数的第 k 个位置断开
     */
    public ListNode rotateRight (ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        // 找到最后一个 node
        ListNode first = head;
        int len = 1;
        while (first.next != null) {
            first = first.next;
            len++;
        }
        first.next = head;
        // 求出倒数第 k 个位置
        k = k % len;
//        if (k == 0) return head;

        // 找出新的头节点， 断开新头节点的与前一个节点的连接
        ListNode newHeadPre = first;
        ListNode newHead = first.next;
        for (int i = 0; i < len - k; i++) {
            newHead = newHead.next;
            newHeadPre = newHeadPre.next;
        }
        newHeadPre.next = null;
        return newHead;
    }
}
