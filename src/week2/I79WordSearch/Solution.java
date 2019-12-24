package week2.I79WordSearch;

public class Solution {
    int col, row;
    String word;
    char[][] board;
    boolean[][] used;
    private int[][] direction = {{- 1, 0}, {1, 0}, {0, - 1}, {0, 1}};

    public boolean exist (char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        this.board = board;
        this.word = word;
        used = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs (int x, int y, int index) {
        if (index == word.length() - 1) {
            if (board[x][y] == word.charAt(index)) {
                return true;
            }
        }
        if (board[x][y] == word.charAt(index)) {
            used[x][y] = true;
            for (int k = 0; k < 4; k++) {
                int newX = x + direction[k][0];
                int newY = y + direction[k][1];
                if (inArea(newX, newY) && ! used[newX][newY]) {
                    if (dfs(newX, newY, index + 1)) {
                        return true;
                    }
                }
            }
            used[x][y] = false;
        }
        return false;
    }

    private boolean inArea (int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
