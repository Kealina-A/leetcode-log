package week14.E171ExcelII;

/**
 * ******************************************************************
 * Date: 2020/3/17  Tue
 * ******************************************************************
 * Title: ✔[171]Excel表列序号
 * ******************************************************************
 * Success:
 * Runtime: ms, faster than % of Java online submissions.
 * Memory Usage: MB, less than % of Java online submissions.
 * ******************************************************************
 */
public class Solution {
    public int titleToNumber (String s) {
        int res = s.charAt(s.length() - 1) - 64;
        for (int i = s.length() - 2, count = 1; i >= 0; i--, count++) {
            int temp = count;
            int j = 1;
            while (temp != 0) {
                j *= 26;
                temp--;
            }
            res += ((s.charAt(i) - 64) * j);
        }
        return res;
    }
}
