package week7.M5LongestPalindromicSubstring;

/**
 * ******************************************************************
 * 日 期: 2020-01-20  星期一
 * ******************************************************************
 * 题 目:   [5]Longest Palindromic Substring
 * //给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * //
 * // 示例 1：
 * //
 * // 输入: "babad"
 * //输出: "bab"
 * //注意: "aba" 也是一个有效答案。
 * //ß
 * // 示例 2：
 * //
 * // 输入: "cbbd"
 * //输出: "bb"
 * //
 * // Related Topics 字符串 动态规划
 * ******************************************************************
 * 执行耗时: 60ms,击败了 41.4% 的Java用户
 * 内存消耗: 37.3MB,击败了 32.49% 的Java用户
 * ******************************************************************
 * 个人总结：官方题解-动态规划
 * ******************************************************************
 */
public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome7("babad"));
    }

    public String longestPalindrome7 (String s) {
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
