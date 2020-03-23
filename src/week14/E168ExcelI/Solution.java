package week14.E168ExcelI;

/**
 * ******************************************************************
 * Date: 2020/3/17  Tue
 * ******************************************************************
 * Title:✔[168]Excel表列名称
 * ******************************************************************
 * Success:
 * Runtime:0 ms, faster than 100.00% of Java online submissions.
 * Memory Usage: 36.6MB, less than % of Java online submissions.
 * ******************************************************************
 */
public class Solution {
    public String convertToTitle (int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 26) {
            int i = 0;
            if (n % 26 == 0) {
                n = n - 1;
                i = 1;
            }
            sb.append((char) (n % 26 + 64 + i));
            n /= 26;
        }
        sb.append((char) (64 + n));
        return sb.reverse().toString();
    }
}
