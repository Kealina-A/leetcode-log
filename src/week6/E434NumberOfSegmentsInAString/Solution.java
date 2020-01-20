package week6.E434NumberOfSegmentsInAString;

/**
 * ******************************************************************
 * 日 期: 2020-01-18  星期六
 * ******************************************************************
 * 题 目:   [434]Number of Segments in a String
 * //统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * //
 * // 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * //
 * // 示例:
 * //
 * // 输入: "Hello, my name is John"
 * //输出: 5
 * //
 * // Related Topics 字符串
 * ******************************************************************
 * 执行耗时: ms,击败了 % 的Java用户
 * 内存消耗: MB,击败了 % 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class Solution {
    public static void main (String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSegments("Hello, my name is John"));
    }

    public int countSegments (String s) {
        int i = 0, count = 0;
        boolean flag = false;
        while (i < s.length()) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                flag = false;
            } else {
                if (! flag) {
                    flag = true;
                }
            }
            i++;
            if (flag) {
                count++;
            }
        }
        return count;
    }
}
