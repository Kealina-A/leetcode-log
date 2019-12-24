package week2.I784LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> result = new ArrayList<>();
    int diff = 'a'-'A';
    public List<String> letterCasePermutation(String S) {
        dfs(0, S.toCharArray());
        return result;
    }

    public void dfs (int index,char[] chars) {
        if (index==chars.length) {
            result.add(String.valueOf(chars));
            return;
        }
        char aChar = chars[index];
        if (Character.isLetter(aChar)) {
            if (Character.isLowerCase(aChar)) {
                chars[index] = (char) (aChar-diff);
                dfs(index+1,chars);
                chars[index] = aChar;
            } else {
                chars[index] = (char) (aChar+diff);
                dfs(index+1,chars);
                chars[index] = aChar;
            }
        }
        dfs(index+1,chars);
    }
}
