package contest.weekly181.M5178;

import java.util.ArrayList;
import java.util.List;

/**
 * ******************************************************************
 * Date: 2020/3/22  Sun
 * ******************************************************************
 * Title:5178. 四因数
 * ******************************************************************
 * Success:
 * Runtime: ms, faster than % of Java online submissions.
 * Memory Usage: MB, less than % of Java online submissions.
 * ******************************************************************
 */
public class Solution {

    public int sumFourDivisors (int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int count = 0;
            int div = 1;
            List<Integer> x = new ArrayList<>();
            while (div <= num) {
                if (num % div == 0) {
                    count++;
                    x.add(div);
                    if (count > 4) break;
                }
                div++;
            }
            if (count == 4) {
                sum += x.stream().reduce(0, Integer :: sum);
            }
        }
        return sum;
    }
}
