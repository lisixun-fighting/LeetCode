package may;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0][0] == target)
            return true;
        boolean[][] avail = new boolean[matrix.length][matrix[0].length];
        return dfs(matrix, avail, 0, 1, target) || dfs(matrix, avail, 1, 0, target);
    }

    private boolean dfs(int[][] matrix, boolean[][] avail, int i, int j, int target) {
        if (i == matrix.length || j == matrix[0].length || avail[i][j])
            return false;
        avail[i][j] = true;
        if (matrix[i][j] == target)
            return true;
        if (matrix[i][j] > target)
            return false;
        return dfs(matrix, avail, i+1, j, target) || dfs(matrix, avail, i, j+1, target);
    }
}
