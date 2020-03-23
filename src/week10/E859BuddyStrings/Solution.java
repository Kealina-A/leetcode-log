package week10.E859BuddyStrings;

import java.util.HashSet;
import java.util.Set;

/**
 * ******************************************************************
 * Date: 2020/2/20  Thu
 * ******************************************************************
 * Title:
 * ******************************************************************
 * Success:
 * Runtime: 2ms, faster than 80.54% of Java online submissions.
 * Memory Usage: 39MB, less than 5.02% of Java online submissions.
 * ******************************************************************
 */
public class Solution {

    public boolean buddyStrings (String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.length() == 0) return false;
        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < A.length(); i++) {
                if (set.contains(A.charAt(i))) return true;
                set.add(A.charAt(i));
            }
            return false;
        }
        int first = - 1;
        int scond = - 1;
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (count == 0) {
                    first = i;
                }
                if (count == 1) {
                    scond = i;
                }
                count++;
                if (count == 2) {
                    break;
                }
            }
        }
        if (first < 0 || scond < 0) {
            return false;
        }
        return A.charAt(first) == B.charAt(scond) && A.charAt(scond) == B.charAt(first) && ((scond == A.length() - 1) || A.substring(scond).equals(B.substring(scond)));
    }
}
