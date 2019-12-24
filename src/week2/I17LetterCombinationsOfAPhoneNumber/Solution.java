package week2.I17LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> result = new ArrayList<>();
    private String digits;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        dfs(0,null);
        return result;
    }


    public void dfs (int currentDeep,StringBuffer stringBuffer){
        if (currentDeep == digits.length()) {
            if (stringBuffer==null) {
                return;
            }
            result.add(stringBuffer.toString());
            return;
        }

        char[] currentLetterArray = getLetter(digits.charAt(currentDeep));
        if (currentLetterArray==null) {
            dfs(currentDeep+1,stringBuffer);
            return;
        }
        for (int i = 0; i < currentLetterArray.length; i++) {
            StringBuffer newStringBuffer = new StringBuffer(stringBuffer==null?"":stringBuffer).append(currentLetterArray[i]);
            dfs(currentDeep+1,newStringBuffer);
        }
    }

    public char[] getLetter(char digit) {
        switch (digit) {
            case '2': return new char[]{'a','b','c'};
            case '3': return new char[]{'d','e','f'};
            case '4': return new char[]{'g','h','i'};
            case '5': return new char[]{'j','k','l'};
            case '6': return new char[]{'m','n','o'};
            case '7': return new char[]{'p','q','r','s'};
            case '8': return new char[]{'t','u','v'};
            case '9': return new char[]{'w','x','y','z'};
            default: return null;
        }
    }
}
