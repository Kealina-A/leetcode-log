package week8.M150EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * ******************************************************************
 * 日 期: 2020-02-01  星期六
 * ******************************************************************
 * 题 目:   [150]Evaluate Reverse Polish Notation
 * //根据逆波兰表示法，求表达式的值。
 * //
 * // 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * //
 * // 说明：
 * //
 * //
 * // 整数除法只保留整数部分。
 * // 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * //
 * //
 * // 示例 1：
 * //
 * // 输入: ["2", "1", "+", "3", "*"]
 * //输出: 9
 * //解释: ((2 + 1) * 3) = 9
 * //
 * //
 * // 示例 2：
 * //
 * // 输入: ["4", "13", "5", "/", "+"]
 * //输出: 6
 * //解释: (4 + (13 / 5)) = 6
 * //
 * //
 * // 示例 3：
 * //
 * // 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * //输出: 22
 * //解释:
 * //  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * //= ((10 * (6 / (12 * -11))) + 17) + 5
 * //= ((10 * (6 / -132)) + 17) + 5
 * //= ((10 * 0) + 17) + 5
 * //= (0 + 17) + 5
 * //= 17 + 5
 * //= 22
 * // Related Topics 栈
 * ******************************************************************
 * 执行耗时: 9ms,击败了 66.49% 的Java用户
 * 内存消耗: 36.1MB,击败了 98.67% 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class Solution {
    public static void main (String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public int evalRPN (String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                switch (token) {
                    case "/":
                        stack.push(b / a);
                        break;
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
