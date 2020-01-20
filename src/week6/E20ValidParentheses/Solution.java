package week6.E20ValidParentheses;

import java.util.Stack;

/**
 * ******************************************************************
 * 日 期: 2020-01-17  星期五
 * ******************************************************************
 * 题 目:✔[20]Valid Parentheses
 * //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * //
 * // 有效字符串需满足：
 * //
 * //
 * // 左括号必须用相同类型的右括号闭合。
 * // 左括号必须以正确的顺序闭合。
 * //
 * //
 * // 注意空字符串可被认为是有效字符串。
 * //
 * // 示例 1:
 * //
 * // 输入: "()"
 * //输出: true
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: "()[]{}"
 * //输出: true
 * //
 * //
 * // 示例 3:
 * //
 * // 输入: "(]"
 * //输出: false
 * //
 * //
 * // 示例 4:
 * //
 * // 输入: "([)]"
 * //输出: false
 * //
 * //
 * // 示例 5:
 * //
 * // 输入: "{[]}"
 * //输出: true
 * // Related Topics 栈 字符串
 * ******************************************************************
 * 执行耗时: 2ms,击败了 93.76% 的Java用户
 * 内存消耗: 34.1MB,击败了 % 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class Solution {
    public boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.add(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (aChar == ')' && '(' != pop) {
                    return false;
                }
                if (aChar == ']' && '[' != pop) {
                    return false;
                }
                if (aChar == '}' && '{' != pop) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
