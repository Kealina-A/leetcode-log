package week8.E496NextGreaterElementI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ******************************************************************
 * 日 期: 2020-01-30  星期四
 * ******************************************************************
 * 题 目:   [496]Next Greater Element I
 * //给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * //
 * // nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * //
 * // 示例 1:
 * //
 * //
 * //输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * //输出: [-1,3,-1]
 * //解释:
 * //    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * //    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * //    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * //
 * // 示例 2:
 * //
 * //
 * //输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * //输出: [3,-1]
 * //解释:
 * //    对于num1中的数字2，第二个数组中的下一个较大数字是3。
 * //    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * //
 * //
 * // 注意:
 * //
 * //
 * // nums1和nums2中所有元素是唯一的。
 * // nums1和nums2 的数组大小都不超过1000。
 * //
 * // Related Topics 栈
 * ******************************************************************
 * 执行耗时: 4ms,击败了 85.69% 的Java用户
 * 内存消耗: 37.2MB,击败了 34.71% 的Java用户
 * ******************************************************************
 * 个人总结：暴力解法
 * ******************************************************************
 */
public class Solution {
    public int[] nextGreaterElement (int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, - 1);
        Map<Integer, Integer> nums2Map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            nums2Map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            Integer index = nums2Map.get(nums1[i]);
            if (index < nums2.length - 1) {
                for (int j = index + 1; j < nums2.length; j++) {
                    if (nums2[j] > nums1[i]) {
                        res[i] = nums2[j];
                        break;
                    }
                }
            }
        }
        return res;
    }

}
