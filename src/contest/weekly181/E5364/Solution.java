package contest.weekly181.E5364;

import java.util.LinkedList;
import java.util.List;

/**
 * ******************************************************************
 * Date: 2020/3/22  Sun
 * ******************************************************************
 * Title: 5364. 按既定顺序创建目标数组
 * ******************************************************************
 * Success:
 * Runtime: ms, faster than % of Java online submissions.
 * Memory Usage: MB, less than % of Java online submissions.
 * ******************************************************************
 */
public class Solution {
    public int[] createTargetArray (int[] nums, int[] index) {
        int len = nums.length;
        if (len == 0) return new int[0];
        List<Integer> target = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            target.add(index[i], nums[i]);
        }
        int[] t = new int[len];
        int count = 0;
        for (Integer integer : target) {
            t[count++] = integer;
        }
        return t;
    }
}
