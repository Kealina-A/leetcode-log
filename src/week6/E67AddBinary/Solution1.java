package week6.E67AddBinary;

/**
 * 执行出错
 * 当超过int的最大值时报错
 */
public class Solution1 {

    public static void main (String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.addBinary("11", "1"));
    }

    public String addBinary (String a, String b) {
        int aT = Integer.valueOf(a, 2);
        int bT = Integer.valueOf(b, 2);
        return Integer.toBinaryString(aT + bT);
    }
}
