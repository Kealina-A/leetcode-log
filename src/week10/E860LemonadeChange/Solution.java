package week10.E860LemonadeChange;

/**
 * ******************************************************************
 * Date: 2020/2/20  Thu
 * ******************************************************************
 * Title: [860] lemonade-change
 * ******************************************************************
 * Success:
 * Runtime:3 ms, faster than 37.59% of Java online submissions.
 * Memory Usage:42.8 MB, less than 5.13% of Java online submissions.
 * ******************************************************************
 */
public class Solution {

    public boolean lemonadeChange (int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    five -= 1;
                    ten -= 1;
                } else if (five > 2) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
