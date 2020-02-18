package week9.H23MergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ******************************************************************
 * Date: 2020/2/11  Tue
 * ******************************************************************
 * Title:   [23]合并K个排序链表
 * //合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * //
 * // 示例:
 * //
 * // 输入:
 * //[
 * //  1->4->5,
 * //  1->3->4,
 * //  2->6
 * //]
 * //输出: 1->1->2->3->4->4->5->6
 * // Related Topics 堆 链表 分治算法
 * ******************************************************************
 * 执行耗时: 10ms,击败了 42.16% 的Java用户
 * 内存消耗:52.3 MB,击败了 19.5% 的Java用户
 * ******************************************************************
 * 小顶堆实现
 * ******************************************************************
 */
public class Solution {

    public ListNode mergeKLists (ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, Comparator.comparingInt(n -> n.val));

        ListNode preHead = new ListNode(- 1);
        ListNode pre = preHead;

        for (ListNode list : lists) {
            if (list == null) continue;
            minHeap.offer(list);
        }

        while (! minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            pre.next = minNode;
            pre = pre.next;
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }
        return preHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }
}
