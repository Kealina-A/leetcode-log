package week6.E345ReverseVowelsOfAString;

/**
 * ******************************************************************
 * 日 期: 2020-01-17  星期五
 * ******************************************************************
 * 题 目: [345]Reverse Vowels of a String
 * //编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * //
 * // 示例 1:
 * //
 * // 输入: "hello"
 * //输出: "holle"
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: "leetcode"
 * //输出: "leotcede"
 * //
 * // 说明:
 * //元音字母不包含字母"y"。
 * // Related Topics 双指针 字符串
 * ******************************************************************
 * 执行耗时:3 ms,击败了96.30% 的Java用户
 * s内存消耗:36.2 MB,击败了99.37% 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class Solution {
    public String reverseVowels (String s) {
        char[] charArray = s.toCharArray();
        int i = 0, j = charArray.length - 1;
        while (i < j) {
            if (charArray[i] == charArray[j]) {
                i++;
                j--;
                continue;
            }
            if (isVowel(charArray[i])) {
                if (isVowel(charArray[j])) {
                    char tmp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = tmp;
                    i++;
                }
                j--;
            } else {
                i++;
            }
        }
        return String.valueOf(charArray);
    }

    public boolean isVowel (char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
