package week13.E9;

/**
 * ******************************************************************
 * Date: 2020/3/14  Sat
 * ******************************************************************
 * Title: [9]isPalindrome
 * ******************************************************************
 * Success:
 * Runtime:10 ms, faster than 65.85% of Java online submissions.
 * Memory Usage:40.7 MB, less than 5.00% of Java online submissions.
 * ******************************************************************
 */
public class Solution1 {
    public static void main (String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome (int x) {
        String s = String.valueOf(x);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
