package week6.E415AddStrings;

/**
 * ******************************************************************
 * 日 期: 2020-01-17  星期五
 * ******************************************************************
 * 题 目: [415]Add Strings
 * //给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * //
 * // 注意：
 * //
 * //
 * // num1 和num2 的长度都小于 5100.
 * // num1 和num2 都只包含数字 0-9.
 * // num1 和num2 都不包含任何前导零。
 * // 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * //
 * // Related Topics 字符串
 * ******************************************************************
 * 执行耗时: 2ms,击败了 99.20% 的Java用户
 * 内存消耗: 36.3MB,击败了 26.32% 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class Solution {
    public static void main (String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("1", "9"));
    }

    public String addStrings (String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int t = carry;
            if (i >= 0) t += num1.charAt(i--) - '0';
            if (j >= 0) t += num2.charAt(j--) - '0';
            carry = t / 10;
            sb.append(t % 10);
        }
        if (carry >= 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
