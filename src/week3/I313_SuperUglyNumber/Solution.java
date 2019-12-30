package week3.I313_SuperUglyNumber;

public class Solution {

    public static void main (String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.nthSuperUglyNumber(2, new int[]{2, 3, 5}));
    }

    public int nthSuperUglyNumber (int n, int[] primes) {
        int[] res = new int[n];
        int[] indexArray = new int[n];
        res[0] = 1;
        int len = Math.min(n, primes.length);
        for (int j = 1; j < n; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                min = Math.min(min, res[indexArray[i]] * primes[i]);
            }
            for (int i = 0; i < len; i++) {
                if (min == res[indexArray[i]] * primes[i]) indexArray[i]++;
            }
            res[j] = min;
        }
        return res[n - 1];
    }
}
