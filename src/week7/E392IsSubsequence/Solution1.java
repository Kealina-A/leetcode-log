package week7.E392IsSubsequence;

/**
 * ******************************************************************
 * 日 期: 2020-01-26  星期日
 * ******************************************************************
 * 题 目:   [392]Is Subsequence
 * //给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * //
 * // 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * //
 * // 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * //
 * // 示例 1:
 * //s = "abc", t = "ahbgdc"
 * //
 * // 返回 true.
 * //
 * // 示例 2:
 * //s = "axc", t = "ahbgdc"
 * //
 * // 返回 false.
 * //
 * // 后续挑战 :
 * //
 * // 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * //
 * // 致谢:
 * //
 * // 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * // Related Topics 贪心算法 二分查找 动态规划
 * ******************************************************************
 * 执行耗时:518 ms,击败了 5.05 % 的Java用户
 * 内存消耗:120.6 MB,击败了5.18% 的Java用户
 * ******************************************************************
 * 个人总结：动态规划解法
 * ******************************************************************
 */
public class Solution1 {

    public static void main (String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.isSubsequence("leeeeetcode", "yyleyyeyeeyeeyytcodyyey");
    }

    public boolean isSubsequence (String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen > tLen) return false;
        if (sLen == 0) return true;
        boolean[][] memo = new boolean[sLen + 1][tLen + 1];
        for (int j = 0; j < tLen; j++) {
            memo[0][j] = true;
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {
                    memo[i][j] = memo[i][j - 1];
                }
            }
        }
        return memo[sLen][tLen];
    }
}
