package week11;

/**
 * ******************************************************************
 * Date: 2020/3/1  Sun
 * ******************************************************************
 * Title: [4] median-of-two-sorted-arrays
 * ******************************************************************
 * Success:
 * Runtime: 3.0ms, faster than5 95.4% of Java online submissions.
 * Memory Usage: 41.9MB, less than 96.96 % of Java online submissions.
 * ******************************************************************
 */
public class H4MedianOfTwoSortedArrays {

    public double findMedianSortedArrays (int[] nums1, int[] nums2) {
        int[] newArray = merge(nums1, nums2);
        int len = newArray.length;
        int x = len / 2;
        if (len % 2 != 0) return newArray[x];
        return (double) (newArray[x] + newArray[x - 1]) / (double) 2;
    }

    public static int[] merge (int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0, rIndex = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[rIndex++] = nums1[i++];
            } else {
                res[rIndex++] = nums2[j++];
            }
        }
        while (i != nums1.length) {
            res[rIndex++] = nums1[i++];
        }
        while (j != nums2.length) {
            res[rIndex++] = nums2[j++];
        }
        return res;
    }
}
