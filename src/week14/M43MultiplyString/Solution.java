package week14.M43MultiplyString;

/**
 * ******************************************************************
 * Date: 2020/3/20  Fri
 * ******************************************************************
 * Title: 5348. 两个数组间的距离值
 * ******************************************************************
 * Success:
 * Runtime: ms, faster than % of Java online submissions.
 * Memory Usage: MB, less than % of Java online submissions.
 * ******************************************************************
 */
public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        solution.multiply("2", "3");
    }

    public String multiply (String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int flag = 0;
        while (i >= 0 && j >= 0) {
            int x = (num1.charAt(i) - 48) * (num2.charAt(j) - 48) + flag;
            sb.append((x % 10));
            flag = x / 10;
            i--;
            j--;
        }
        if (i >= 0) {
            sb = sb.reverse();
            sb.append(num1.substring(i));
            return sb.toString();
        }
        if (j >= 0) {
            sb = sb.reverse();
            sb.append(num2.substring(j));
            return sb.toString();
        }
        return sb.reverse().toString();
    }
}
