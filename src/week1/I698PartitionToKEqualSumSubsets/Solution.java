package week1.I698PartitionToKEqualSumSubsets;

public class Solution {
    int target;
    int[] nums;
    boolean[] usedMemo;

    public boolean search (int k, int currentVal,int startIndex) {

        if (k == 0) {
            return true;
        }
        if (currentVal == target) {
            return search(k - 1, 0,0);
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (! usedMemo[i] && currentVal + nums[i] <= target) {
                usedMemo[i] = true;
                if (search(k, currentVal + nums[i],i+1)) return true;
                usedMemo[i] = false;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets (int[] nums, int k) {

        this.nums = nums;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        target = sum / k;
        if (sum % k != 0 || max > target) {
            return false;
        }
        usedMemo = new boolean[nums.length];
        return search(k, 0,0);
    }

}
