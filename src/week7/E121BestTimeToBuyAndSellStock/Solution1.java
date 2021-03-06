package week7.E121BestTimeToBuyAndSellStock;

/**
 * ******************************************************************
 * 日 期: 2020-01-23  星期四
 * ******************************************************************
 * 题 目:   [121]Best Time to Buy and Sell Stock
 * //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * //
 * // 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * //
 * // 注意你不能在买入股票前卖出股票。
 * //
 * // 示例 1:
 * //
 * // 输入: [7,1,5,3,6,4]
 * //输出: 5
 * //解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * //     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: [7,6,4,3,1]
 * //输出: 0
 * //解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * //
 * // Related Topics 数组 动态规划
 * ******************************************************************
 * 执行耗时:1 ms,击败了99.99% 的Java用户
 * 内存消耗:37 MB,击败了76.89% 的Java用户
 * ******************************************************************
 * 个人总结：求最大值和最小值。
 * ******************************************************************
 */
public class Solution1 {
    public static void main (String[] args) {
        Solution1 solution = new Solution1();
        solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }

    public int maxProfit (int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(prices[i] - min, max);
            }
        }
        return max;
    }
}
