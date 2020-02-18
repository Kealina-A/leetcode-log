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
 * 内存消耗: 41.8MB,击败了5.02 % 的Java用户
 * ******************************************************************
 * 迭代解法
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

    //1->2-3->4->5  --> 1<-2<-3<-4<-5
    public ListNode reverseList (ListNode head) {
        ListNode pre = null, cur = head, nxt = head;
        while (cur != null) {
            // 示例 当 cur = 1，用 nxt 来保存 cur 的 next,因为要将 1 的 next 改向，所以得保存起来
            nxt = cur.next;
            // cur 的 next 改向指向前一个 pre
            cur.next = pre;
            // 上面已经改完向，此时进行下一次迭代，当前的 cur 将成为过去，即赋值给 pre，前的 cur 将到来，即为 nxt
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
