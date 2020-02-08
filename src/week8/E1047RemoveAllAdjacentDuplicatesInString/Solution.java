package week8.E1047RemoveAllAdjacentDuplicatesInString;

import java.util.Stack;

/**
 * ******************************************************************
 * 日 期: 2020-01-30  星期四
 * ******************************************************************
 * 题 目:   [1047]Remove All Adjacent Duplicates In String
 * //给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * //
 * // 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * //
 * // 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * //
 * // 示例：
 * //
 * // 输入："abbaca"
 * //输出："ca"
 * //解释：
 * //例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * //
 * // 提示：
 * //
 * // 1 <= S.length <= 20000
 * // S 仅由小写英文字母组成。
 * //
 * // Related Topics 栈
 * ******************************************************************
 * 执行耗时: 51ms,击败了 61.94% 的Java用户
 * 内存消耗: 38.4MB,击败了 33.04% 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class Solution {
    public String removeDuplicates (String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
