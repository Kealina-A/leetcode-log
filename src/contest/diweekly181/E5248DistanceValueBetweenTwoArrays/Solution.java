package contest.diweekly181.E5248DistanceValueBetweenTwoArrays;

/**
 * ******************************************************************
 * Date: 2020/3/21  Sat
 * ******************************************************************
 * Title:
 * ******************************************************************
 * Success:
 * Runtime: ms, faster than % of Java online submissions.
 * Memory Usage: MB, less than % of Java online submissions.
 * ******************************************************************
 */
public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        System.out.println(solution.findTheDistanceValue(arr1, arr2, 2));
    }

    public int findTheDistanceValue (int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            int j = 0;
            arr2:
            for (; j < arr2.length; j++) {
                int abs = Math.abs(arr1[i] - arr2[j]);
                if (abs <= d) {
                    break arr2;
                }
            }
            if (j == arr2.length) {
                count++;
            }
        }
        return count;
    }
}
