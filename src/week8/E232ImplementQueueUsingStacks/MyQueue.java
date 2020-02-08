package week8.E232ImplementQueueUsingStacks;

import java.util.LinkedList;

/**
 * ******************************************************************
 * 日 期: 2020-01-30  星期四
 * ******************************************************************
 * 题 目:   [232]Implement Queue using Stacks
 * //使用栈实现队列的下列操作：
 * //
 * //
 * // push(x) -- 将一个元素放入队列的尾部。
 * // pop() -- 从队列首部移除元素。
 * // peek() -- 返回队列首部的元素。
 * // empty() -- 返回队列是否为空。
 * //
 * //
 * // 示例:
 * //
 * // MyQueue queue = new MyQueue();
 * //
 * //queue.push(1);
 * //queue.push(2);
 * //queue.peek();  // 返回 1
 * //queue.pop();   // 返回 1
 * //queue.empty(); // 返回 false
 * //
 * // 说明:
 * //
 * //
 * // 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * // 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * // 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * //
 * // Related Topics 栈 设计
 * ******************************************************************
 * 执行耗时:0 ms,击败了 100.00% 的Java用户
 * 内存消耗:34.2 MB,击败了 5.79% 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class MyQueue {
    private LinkedList<Integer> deque;

    /**
     * Initialize your data structure here.
     */
    public MyQueue () {
        deque = new LinkedList();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push (int x) {
        deque.addFirst(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop () {
        return deque.removeLast();
    }

    /**
     * Get the front element.
     */
    public int peek () {
        return deque.getLast();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty () {
        return deque.isEmpty();
    }
}
