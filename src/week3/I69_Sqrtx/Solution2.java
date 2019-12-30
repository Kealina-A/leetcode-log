package week3.I69_Sqrtx;

public class Solution2 {

    public int mySqrt (int x) {
        if (x < 2) {
            return x;
        }
        for (long i = 1; i <= x / 2 + 1; i++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                return (int) i;
            }
        }
        return 0;
    }
}
