package week7.E303RangeSumQueryImmutable;

/**
 * ******************************************************************
 * 日 期: 2020-01-26  星期日
 * ******************************************************************
 * 题 目:   [303]Range Sum Query - Immutable
 * //给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
 * //
 * // 示例：
 * //
 * // 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * //
 * //sumRange(0, 2) -> 1
 * //sumRange(2, 5) -> -1
 * //sumRange(0, 5) -> -3
 * //
 * // 说明:
 * //
 * //
 * // 你可以假设数组不可变。
 * // 会多次调用 sumRange 方法。
 * //
 * // Related Topics 动态规划
 * ******************************************************************
 * 执行耗时: 12ms,击败了 99.53% 的Java用户
 * 内存消耗: 41.6MB,击败了 65.4% 的Java用户
 * ******************************************************************
 * 个人总结：无
 * ******************************************************************
 */

public class NumArray {

    public static void main (String[] args) {
        NumArray numArray = new NumArray(new int[]{- 2, 0, 3, - 5, 2, - 1});
        numArray.sumRange(0, 2);
    }

    private int[] nums;
    private int[] memo;

    public NumArray (int[] nums) {
        this.nums = nums;
        this.memo = new int[nums.length];
        init();
    }

    private void init () {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            memo[i] = s;
        }
    }

    public int sumRange (int i, int j) {
        if (i == 0) return memo[j];
        return memo[j] - memo[i - 1];
    }
}
