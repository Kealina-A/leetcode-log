package week14.E172FactorialTrailingZeroes;

/**
 * ******************************************************************
 * Date: 2020/3/18  Wed
 * ******************************************************************
 * Title: ✔[172]阶乘后的零[168
 * ******************************************************************
 * Success:
 * Runtime: ms, faster than % of Java online submissions.
 * Memory Usage: MB, less than % of Java online submissions.
 * ******************************************************************
 */
public class Solution {

    public int trailingZeroes (int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
