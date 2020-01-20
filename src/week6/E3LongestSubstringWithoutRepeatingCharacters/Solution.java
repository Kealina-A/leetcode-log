package week6.E3LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring (String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, ans = 0;

        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
}
