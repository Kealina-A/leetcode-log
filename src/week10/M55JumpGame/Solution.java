package week10.M55JumpGame;

/**
 * ******************************************************************
 * Date: 2020/2/23  Sun
 * ******************************************************************
 * Title: [55] Jump Game
 * ******************************************************************
 * Success:
 * Runtime: 2 ms, faster than 100.00% of Java online submissions.
 * Memory Usage:41.1 MB, less than % of Java online submissions.
 * ******************************************************************
 */
public class Solution {
    public boolean canJump (int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k > i) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
