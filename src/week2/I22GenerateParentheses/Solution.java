package week2.I22GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> ans = new ArrayList<>();
    int max;
    public List<String> generateParenthesis(int n) {
        max = n;
        backtrack("",0,0);
        return ans;
    }

    public void backtrack (String str,int open, int close) {
        if (str.length()==max*2) {
            ans.add(str);
            return;
        }

        if (open<max) {
            backtrack(str+"(",open+1,close);
        }
        if (close<open) {
            backtrack(str+")",open,close+1);
        }
    }
}
