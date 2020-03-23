package week14.EI0106CompressString;

/**
 * ******************************************************************
 * Date: 2020/3/16  Mon
 * ******************************************************************
 * Title: ✔[面试题 01.06]字符串压缩
 * ******************************************************************
 * Success:
 * Runtime: 5ms, faster than 88.28% of Java online submissions.
 * Memory Usage:38.5 MB, less than 100.00 % of Java online submissions.
 * ******************************************************************
 */
public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        solution.compressString("aaabbbccc");
    }

    public String compressString (String S) {
        if (S.length() == 0) return S;
        int num = 1;
        char cur = S.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(cur);
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == cur) {
                num++;
            } else {
                sb.append(num);
                cur = S.charAt(i);
                sb.append(cur);
                num = 1;
            }
        }
        sb.append(num);
        return sb.toString().length() >= S.length() ? S : sb.toString();
    }
}
