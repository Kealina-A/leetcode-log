package I264_UglyNumberII;

public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        int i = solution.nthUglyNumber(1690);
        System.out.println(i);
    }

    /**
     * 由于都要是丑数的倍数，所有列表肯定是由一个或多个2、3、5组合相乘得到，
     * 顺序排列得出这些组合的数值，直到得到第n个丑数
     */
    public int nthUglyNumber (int n) {
        int[] res = new int[n];
        res[0] = 1;
        int index = 0;
        int n2 = 0, n3 = 0, n5 = 0;
        while (index++ < n - 1) {
            int tmp = Math.min(Math.min(res[n2] * 2, res[n3] * 3), res[n5] * 5);
            res[index] = tmp;
            if (tmp == res[n2] * 2) n2++;
            if (tmp == res[n3] * 3) n3++;
            if (tmp == res[n5] * 5) n5++;
        }
        return res[n - 1];
    }

}
