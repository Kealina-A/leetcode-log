package week10.E867TransposeMatrix;

/**
 * ******************************************************************
 * Date: 2020/2/20  Thu
 * ******************************************************************
 * Title: [867] transpose-matrix
 * ******************************************************************
 * Success:
 * Runtime: 0ms, faster than 100.00% of Java online submissions.
 * Memory Usage: 41.6MB, less than 5.15% of Java online submissions.
 * ******************************************************************
 */
public class Solution {

    public int[][] transpose (int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] newA = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newA[j][i] = A[i][j];
            }
        }
        int x = 1;
        x = (x ^ 1);
        return newA;
    }
}
