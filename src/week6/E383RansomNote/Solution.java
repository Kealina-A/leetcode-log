package week6.E383RansomNote;

/**
 * ******************************************************************
 * 日 期: 2020-01-17  星期五
 * ******************************************************************
 * 题 目: [383]Ransom Note
 * //给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * //
 * // (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * //
 * // 注意：
 * //
 * // 你可以假设两个字符串均只含有小写字母。
 * //
 * //
 * //canConstruct("a", "b") -> false
 * //canConstruct("aa", "ab") -> false
 * //canConstruct("aa", "aab") -> true
 * //
 * // Related Topics 字符串
 * ******************************************************************
 * 执行耗时:1 ms,击败了100.00% 的Java用户
 * 内存消耗:37.1 MB,击败了93.62% 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */
public class Solution {
    public boolean canConstruct (String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        int[] cap = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int index = magazine.indexOf(c, cap[c - 'a']);
            if (index == - 1) return false;
            cap[c - 'a'] = index + 1;
        }
        return true;
    }
}
