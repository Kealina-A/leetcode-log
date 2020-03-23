package week10.H765CouplesHoldingHands;

/**
 * ******************************************************************
 * Date: 2020/2/21  Fri
 * ******************************************************************
 * Title: [765] couples-holding-hands
 * ******************************************************************
 * Success:
 * Runtime: 1ms, faster than 51.12% of Java online submissions.
 * Memory Usage: 36.7MB, less than 6.35% of Java online submissions.
 * ******************************************************************
 */
public class Solution {

    public int minSwapsCouples (int[] row) {
        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            int x = row[i];
            if (row[i + 1] == (x ^ 1)) continue;
            ans++;
            for (int j = i + 1; j < row.length; j++) {
                if (row[j] == (x ^ 1)) {
                    row[j] = row[i + 1];
                    row[i + 1] = (x ^ 1);
                }
            }
        }
        return ans;
    }
}
