package week6.E125ValidPalindrome;

/**
 * 执行耗时:4 ms,击败了86.70% 的Java用户
 * 内存消耗:36.5 MB,击败了95.32% 的Java用户
 */
public class Solution {
    public static void main (String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("aabcbaa"));
    }

    public boolean isPalindrome (String s) {
        int headIndex = 0, tailIndex = s.length() - 1;
        while (headIndex < tailIndex) {
            char a = s.charAt(headIndex);
            char b = s.charAt(tailIndex);
            if (! isNumberOrLetter(a)) {
                headIndex++;
                continue;
            }
            if (! isNumberOrLetter(b)) {
                tailIndex--;
                continue;
            }
            if (isEqual(a, b)) {
                headIndex++;
                tailIndex--;
            } else {
                return false;
            }
        }
        return (tailIndex - headIndex) <= 1;
    }

    public boolean isNumberOrLetter (char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    public boolean isEqual (char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}
