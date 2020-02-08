package week8.E155MinStack;

import java.util.Stack;

/**
 * ******************************************************************
 * 日 期: 2020-01-30  星期四
 * ******************************************************************
 * 题 目:   [155]Min Stack
 * //设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * //
 * //
 * // push(x) -- 将元素 x 推入栈中。
 * // pop() -- 删除栈顶的元素。
 * // top() -- 获取栈顶元素。
 * // getMin() -- 检索栈中的最小元素。
 * //
 * //
 * // 示例:
 * //
 * // MinStack minStack = new MinStack();
 * //minStack.push(-2);
 * //minStack.push(0);
 * //minStack.push(-3);
 * //minStack.getMin();   --> 返回 -3.
 * //minStack.pop();
 * //minStack.top();      --> 返回 0.
 * //minStack.getMin();   --> 返回 -2.
 * //
 * // Related Topics 栈 设计
 * ******************************************************************
 * 执行耗时: 9ms,击败了 48.14% 的Java用户
 * 内存消耗:40.6 MB,击败了 24.86% 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack () {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push (int x) {
        stack.push(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.push(x);
        }
    }

    public void pop () {
        if (stack.size() <= 0) {
            return;
        }
        Integer pop = stack.pop();
        if (pop.equals(helper.peek())) {
            helper.pop();
        }
    }

    public int top () {
        return stack.peek();
    }

    public int getMin () {
        return helper.peek();
    }

}
