package week7.E198HouseRobber;

import java.util.Arrays;

/**
 * ******************************************************************
 * 日 期: 2020-01-23  星期四
 * ******************************************************************
 * 题 目:   [198]House Robber
 * //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * //
 * // 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * //
 * // 示例 1:
 * //
 * // 输入: [1,2,3,1]
 * //输出: 4
 * //解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * //     偷窃到的最高金额 = 1 + 3 = 4 。
 * //
 * // 示例 2:
 * //
 * // 输入: [2,7,9,3,1]
 * //输出: 12
 * //解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * //     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * //
 * // Related Topics 动态规划
 * ******************************************************************
 * 执行耗时: 0ms,击败了 100.00% 的Java用户
 * 内存消耗: 34.4MB,击败了 5.18% 的Java用户
 * ******************************************************************
 * 个人总结：使用memo记录当前房子+向后的最大之和，有两个分叉，就是索引+2或者索引+3的房子最大值情况，
 * ******************************************************************
 */
public class Solution {
    public static void main (String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2, 1, 1, 2}));
    }

    public int rob (int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, - 1);
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            memo[i] = dfs(nums, memo, i, 0);
            max = Math.max(max, memo[i]);
        }
        return max;
    }

    public int dfs (int[] nums, int[] memo, int start, int sum) {
        if (start >= nums.length) return sum;
        if (memo[start] != - 1) return sum + memo[start];
        sum += nums[start];
        return Math.max(dfs(nums, memo, start + 2, sum), dfs(nums, memo, start + 3, sum));
    }
}
