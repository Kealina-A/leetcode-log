package week6.E13RomanToInt;

public class Solution {
    public int romanToInt (String s) {

        char[] chars = s.toCharArray();
        int res = 0;
        char last = '1';
        for (char aChar : chars) {
            res += get(aChar) - s(last, aChar);
            last = aChar;
        }
        return res;
    }

    public int s (char last, char cur) {
        if (last == 'I' && cur == 'V') return 2 * get('I');
        if (last == 'I' && cur == 'X') return 2 * get('I');
        if (last == 'X' && cur == 'L') return 2 * get('X');
        if (last == 'X' && cur == 'C') return 2 * get('X');
        if (last == 'C' && cur == 'D') return 2 * get('C');
        if (last == 'C' && cur == 'M') return 2 * get('C');
        return 0;
    }

    public int get (char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
