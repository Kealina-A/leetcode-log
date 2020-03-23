package week10.H45JumpGameII;

/**
 * ******************************************************************
 * Date: 2020/2/24  Mon
 * ******************************************************************
 * Title: [45] Jump game II
 * ******************************************************************
 * Success:
 * Runtime:2 ms, faster than 95.14% of Java online submissions.
 * Memory Usage:40.7 MB, less than 6.64% of Java online submissions.
 * ******************************************************************
 */
public class Solution {
    public int jump (int[] nums) {
        int k = 0;
        int end = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            k = Math.max(k, i + nums[i]);
            if (i == end) {
                end = k;
                count++;
            }
        }
        return count;
    }
}
