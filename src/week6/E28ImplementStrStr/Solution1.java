package week6.E28ImplementStrStr;

import java.util.Arrays;

/**
 * BM算法 ： '坏字符'
 * 自己实现，不能通过的，要结合'好后缀'
 */
public class Solution1 {

    public static void main (String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.strStr("aaaaa", "bba"));
    }

    public int strStr (String haystack, String needle) {
        if (haystack.length() < needle.length()) return - 1;
        if (haystack.length() == 0 || needle.length() == 0) return 0;

        int[] badCharIndexes = new int[127];
        Arrays.fill(badCharIndexes, - 1);
        for (int i = 0; i < needle.length(); i++) {
            badCharIndexes[needle.charAt(i)] = i;
        }

        int max = haystack.length() - needle.length() + 1;
        for (int i = 0; i < max && i >= 0; ) {
            int j = needle.length() - 1;
            char badChar = '1';
            for (; j >= 0; j--) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    badChar = haystack.charAt(i + j);
                    break;
                }
            }
            if (j == - 1) {
                return i;
            }
            i = i + j - badCharIndexes[badChar];
        }
        return - 1;
    }

}
