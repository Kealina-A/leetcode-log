package week6.E14LongestCommonPrefix;

public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        String[] x = new String[]{"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(x));
    }

    public String longestCommonPrefix (String[] strs) {
        if (strs.length == 0) return "";
        int index = 0;
        char cur = '1';
        StringBuilder res = new StringBuilder();
        while (true) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < index + 1) {
                    return res.toString();
                }
                if (i == 0) {
                    cur = strs[0].charAt(index);
                }
                if (cur != strs[i].charAt(index)) {
                    return res.toString();
                }
                if (i == strs.length - 1) {
                    res.append(cur);
                    index++;
                }
            }
        }
    }
}
