package week6.E67AddBinary;


/**
 * 执行耗时: 2 ms,击败了96.83 % 的Java用户
 * 内存消耗: 36.2MB,击败了 % 的Java用户
 */
public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }

    public String addBinary (String a, String b) {
        if (a.isEmpty()) return b;
        if (b.isEmpty()) return a;
        if (a.length() != b.length()) {
            int abs = Math.abs(a.length() - b.length());
            // 用0补全，让两个字符串长度一样
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < abs; i++) {
                tmp.append("0");
            }
            if (a.length() > b.length()) {
                b = tmp.toString() + b;
            } else {
                a = tmp.toString() + a;
            }
        }

        int i = a.length() - 1;
        boolean flag = false;
        StringBuilder stringBuilder = new StringBuilder();

        while (i >= 0) {
            if (a.charAt(i) == b.charAt(i)) {
                if (flag) {
                    stringBuilder.append(1);
                    flag = false;
                } else {
                    stringBuilder.append(0);
                }
                if (a.charAt(i) == '1') {
                    flag = true;
                }
            } else {
                if (flag) {
                    stringBuilder.append(0);
                    flag = true;
                } else {
                    stringBuilder.append(1);
                }
            }
            i--;
        }
        if (flag) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }
}
