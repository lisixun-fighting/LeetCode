package march;

public class Solution37 {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int i, int j) {
        if(j == 9) i++;
        if(i == 9) return true;
        if(board[i][j] == '.') {
            for (int k = 1; k <= 9 && modify(board, i, j, k); k++) {
                board[i][j] = (char) (k+'0');
                if (dfs(board, i, j+1)) return true;
            }
            return false;
        }
        return dfs(board, i, j+1);
    }

    private boolean modify(char[][] board, int i, int j, int k) {
        for (int i1 = 0; i1 < 9; i1++) {
            if(board[i1][j] == (char) (k+'0')) return false;
        }
        for (int i1 = 0; i1 < 9; i1++) {
            if(board[i][i1] == (char) (k+'0')) return false;
        }
        for (int i1 = 0; i1 < 3; i1++) {
            for (int i2 = 0; i2 < 3; i2++) {
                if(board[i/3*3+i1][j/3*3+i2] == (char) (k+'0')) return false;
            }
        }
        return true;
    }
}
