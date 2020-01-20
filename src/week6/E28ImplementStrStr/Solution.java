package week6.E28ImplementStrStr;

/**
 * 暴力解法
 * 用时：3 ms  内存：36.3 MB
 */
public class Solution {

    public int strStr (String haystack, String needle) {
        if (haystack.length() < needle.length()) return - 1;
        if (haystack.length() == 0 || needle.length() == 0) return 0;

        int max = haystack.length() - needle.length() + 1;
        for (int i = 0; i < max; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return - 1;
    }

}
