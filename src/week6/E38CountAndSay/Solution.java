package week6.E38CountAndSay;

/**
 * 执行耗时:2 ms
 * 内存消耗:34.2 MB
 */
public class Solution {
    public String countAndSay (int n) {
        if (n == 1) return "1";
        String last = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 1, count = 1;
        while (i < last.length() && j < last.length()) {
            if (last.charAt(i) == last.charAt(j)) {
                count++;
            } else {
                sb.append(count).append(last.charAt(i));
                count = 1;
                i = j;
            }
            j++;
        }
        sb.append(count).append(last.charAt(i));
        return sb.toString();
    }
}
