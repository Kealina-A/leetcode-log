package week14.EI40LeastNumbers;

import java.util.Arrays;

/**
 * ******************************************************************
 * Date: 2020/3/20  Fri
 * ******************************************************************
 * Title:   [面试题40]最小的k个数
 * ******************************************************************
 * Success:
 * Runtime: ms, faster than % of Java online submissions.
 * Memory Usage: MB, less than % of Java online submissions.
 * ******************************************************************
 */
public class Solution {
    public int[] getLeastNumbers (int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}
