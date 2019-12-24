package week3.I263_UglyNubmer;


public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isUgly(17));
    }

    private boolean isUgly (int num) {
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) num = num / 2;
        while (num % 3 == 0) num = num / 3;
        while (num % 5 == 0) num = num / 5;
        return num == 1;
    }
}
