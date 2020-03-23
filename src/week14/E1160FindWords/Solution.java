package week14.E1160FindWords;

/**
 * ******************************************************************
 * Date: 2020/3/17  Tue
 * ******************************************************************
 * Title: ✔[1160]拼写单词
 * ******************************************************************
 * Success:
 * Runtime: ms, faster than % of Java online submissions.
 * Memory Usage: MB, less than % of Java online submissions.
 * ******************************************************************
 */
public class Solution {
    public int countCharacters (String[] words, String chars) {
        int[] memo = new int[26];
        for (char aChar : chars.toCharArray()) {
            memo[aChar - 'a']++;
        }
        int res = 0;
        a:
        for (String word : words) {
            int[] x = new int[26];
            for (char w : word.toCharArray()) {
                x[w - 'a']++;
            }
            for (char w : word.toCharArray()) {
                if (x[w - 'a'] > memo[w - 'a']) {
                    continue a;
                }
            }
            res += word.length();
        }
        return res;
    }

}
