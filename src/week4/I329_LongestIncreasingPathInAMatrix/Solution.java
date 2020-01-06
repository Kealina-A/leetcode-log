package week4.I329_LongestIncreasingPathInAMatrix;


public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
//        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        int[][] matrix = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(solution.longestIncreasingPath(matrix));
    }

    private int[][] direction = {{- 1, 0}, {1, 0}, {0, - 1}, {0, 1}};

    private boolean inArea (int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

    private int row = 0;
    private int col = 0;

    public int longestIncreasingPath (int[][] matrix) {
        row = matrix.length;
        if (row == 0) {
            return 0;
        }
        col = matrix[0].length;

        int[][] memo = new int[row][col];
        boolean[][] visited = new boolean[row][col];

        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int dfs = dfs(i, j, matrix, visited, memo);
                max = Math.max(max, dfs);
            }
        }
        return max + 1;
    }

    private int dfs (int i, int j, int[][] matrix, boolean[][] visited, int[][] memo) {
        if (visited[i][j]) {
            return memo[i][j];
        }
        int max = 0;
        for (int k = 0; k < 4; k++) {
            int x = direction[k][0] + i;
            int y = direction[k][1] + j;
            if (inArea(x, y)) {
                int cur = matrix[i][j];
                int dir = matrix[x][y];
                if (cur < dir) {
                    if (visited[x][y]) {
                        max = Math.max(max, 1 + memo[x][y]);
                    } else {
                        int dfs = dfs(x, y, matrix, visited, memo);
                        max = Math.max(max, 1 + dfs);
                    }
                }
            }
        }
        memo[i][j] = max;
        visited[i][j] = true;
        return max;
    }


}
