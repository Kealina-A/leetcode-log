package week13.E9;

/**
 * ******************************************************************
 * Date: 2020/3/14  Sat
 * ******************************************************************
 * Title: [9]isPalindrome
 * ******************************************************************
 * Success:
 * Runtime: ms, faster than % of Java online submissions.
 * Memory Usage: MB, less than % of Java online submissions.
 * ******************************************************************
 */
public class Solution {
    public static void main (String[] args) {
        System.out.println(isPalindrome(1232321));
    }

    public static boolean isPalindrome (int x) {
        int temp = x;
        int count = 1;
        while (temp != 0) {
            temp /= 10;
            count *= 10;
        }
        count /= 10;
        int m = 1;
        while (count > 10 && m < count) {
            int w = (x / m) % 10;
            int t = (x / count) % 10;
            if (w != t) return false;
            count /= 10;
            m *= 10;
        }
        return true;
    }
}
