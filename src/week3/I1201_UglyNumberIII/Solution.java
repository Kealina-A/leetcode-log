package week3.I1201_UglyNumberIII;

public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }

    public int nthUglyNumber (int n, int a, int b, int c) {
        //看到n的范围应该马上联想到是，典型的二分思路
        int low = Math.min(Math.min(a, b), c);                            //下边界显然是a、b、c中最小者
        int high = low * n;                 //上边界是这个最小者的n倍

        long res = binarySearch(low, high, a, b, c, n);

        long leftA = res % a;
        long leftB = res % b;
        long leftC = res % c;

        return (int) (res - Math.min(leftA, Math.min(leftB, leftC)));
    }

    public long binarySearch (long low, long high, int a, int b, int c, long n) {
        if (low >= high) return low;

        long mid = (low + high) >> 1;

        long ab = mcm(a, b);
        long ac = mcm(a, c);
        long bc = mcm(b, c);
        long abc = mcm(ab, c);

        long count = mid / a + mid / b + mid / c - mid / ab - mid / bc - mid / ac + mid / abc;
        if (count == n) return mid;
        if (count < n) return binarySearch(mid + 1, high, a, b, c, n);
        return binarySearch(low, mid - 1, a, b, c, n);
    }

    public long mcm (long a, long b) {

        long multi = a * b;

        while (b > 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }

        return multi / a;
    }

}
