package week3.I69_Sqrtx;

public class Solution {

    public static void main (String[] args) {
        System.out.println(Math.sqrt(0));

    }

    public int mySqrt (int x) {
        long i = x;
        while (i * i > x) {
            i = (i + x / i) / 2;
        }
        return (int) i;
    }
}
