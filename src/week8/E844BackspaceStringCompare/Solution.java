package week8.E844BackspaceStringCompare;

import java.util.Stack;

/**
 * ******************************************************************
 * 日 期: 2020-01-30  星期四
 * ******************************************************************
 * 题 目:   [844]Backspace String Compare
 * //给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * //
 * // 示例 1：
 * //
 * // 输入：S = "ab#c", T = "ad#c"
 * //输出：true
 * //解释：S 和 T 都会变成 “ac”。
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：S = "ab##", T = "c#d#"
 * //输出：true
 * //解释：S 和 T 都会变成 “”。
 * //
 * //
 * // 示例 3：
 * //
 * // 输入：S = "a##c", T = "#a#c"
 * //输出：true
 * //解释：S 和 T 都会变成 “c”。
 * //
 * //
 * // 示例 4：
 * //
 * // 输入：S = "a#c", T = "b"
 * //输出：false
 * //解释：S 会变成 “c”，但 T 仍然是 “b”。
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= S.length <= 200
 * // 1 <= T.length <= 200
 * // S 和 T 只含有小写字母以及字符 '#'。
 * //
 * //
 * //
 * // Related Topics 栈 双指针
 * ******************************************************************
 * 执行耗时: 4ms,击败了 26.42% 的Java用户
 * 内存消耗: 34.5MB,击败了 49.67% 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class Solution {
    public boolean backspaceCompare (String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if ('#' == S.charAt(i)) {
                if (! sStack.isEmpty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if ('#' == T.charAt(i)) {
                if (! tStack.isEmpty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(T.charAt(i));
            }
        }
        if (sStack.size() != tStack.size()) return false;
        while (! sStack.isEmpty()) {
            if (sStack.pop() != tStack.pop()) {
                return false;
            }
        }
        return true;
    }
}
