package week9.E206ReverseLinkedList;

/**
 * ******************************************************************
 * Date: 2020/2/12  Wed
 * ******************************************************************
 * Title:   [206]反转链表
 * //反转一个单链表。
 * //
 * // 示例:
 * //
 * // 输入: 1->2->3->4->5->NULL
 * //输出: 5->4->3->2->1->NULL
 * //
 * // 进阶:
 * //你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * // Related Topics 链表
 * ******************************************************************
 * 执行耗时: 0ms,击败了 100.00% 的Java用户
 * 内存消耗: 42.3MB,击败了5.02 % 的Java用户
 * ******************************************************************
 * 递归解法
 * ******************************************************************
 */
public class Solution1 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }

    //1->2-3->4->5  --> 1<-2<-3<-4<-5
    public ListNode reverseList (ListNode head) {
        if (head == null || head.next == null) return head;
        // cur 会递归到倒数第二个，如例子1-5 ，那些此时的 head 为 4，head.next = 5
        ListNode cur = reverseList(head.next);
        // 所以要把箭头倒过来，就是将 5 的 next 指向 4
        head.next.next = head;
        // 防止死循环
        head.next = null;
        return cur;
    }
}
