package week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ******************************************************************
 * Date: 2020/2/26  Wed
 * ******************************************************************
 * Title:   [15]三数之和
 * //给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三
 * //元组。
 * //
 * // 注意：答案中不可以包含重复的三元组。
 * //
 * //
 * //
 * // 示例：
 * //
 * // 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * //
 * //满足要求的三元组集合为：
 * //[
 * //  [-1, 0, 1],
 * //  [-1, -1, 2]
 * //]
 * //
 * // Related Topics 数组 双指针
 * ******************************************************************
 * Success:
 * Runtime: 29ms, faster than 95.77% of Java online submissions.
 * Memory Usage:45.4 MB, less than 96.46% of Java online submissions.
 * ******************************************************************
 */
public class M15ThreeSum {

    public List<List<Integer>> threeSum (int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1, R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ArrayList<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[L]);
                    r.add(nums[R]);
                    res.add(r);
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return res;
    }
}
