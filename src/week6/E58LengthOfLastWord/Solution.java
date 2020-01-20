package week6.E58LengthOfLastWord;

/**
 * 偷j 写法
 * 执行耗时:1 ms,击败了44.48% 的Java用户
 * 内存消耗:35.8 MB,击败了76.92% 的Java用户
 */
public class Solution {
    public int lengthOfLastWord (String s) {
        if (null == s || s.length() == 0) return 0;
        String[] s1 = s.split(" ");
        if (s1.length == 0) return 0;
        return s1[s1.length - 1].length();
    }
}
