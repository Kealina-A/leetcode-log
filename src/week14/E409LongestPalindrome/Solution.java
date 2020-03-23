package week14.E409LongestPalindrome;

/**
 * ******************************************************************
 * Date: 2020/3/20  Fri
 * ******************************************************************
 * Title:   [409]最长回文串
 * ******************************************************************
 * Success:
 * Runtime: 2ms, faster than 76.75 % of Java online submissions.
 * Memory Usage: 37.7MB, less than 5.16 % of Java online submissions.
 * ******************************************************************
 */
public class Solution {
    public int longestPalindrome (String s) {
        int[] x = new int[128];
        for (char c : s.toCharArray()) {
            x[c]++;
        }

        int count = 0;
        for (int i = 0; i < 128; i++) {
            count += x[i] % 2;
        }
        return count == 0 ? s.length() : s.length() - count + 1;
    }
}
