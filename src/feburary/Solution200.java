package feburary;

public class Solution200 {

    boolean[][] avail;

    public int numIslands(char[][] grid) {
        int num = 0;
        if(grid.length == 0 || grid[0].length == 0) return num;
        avail = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !avail[i][j]) {
                    num++;
                    dps(i, j, grid);
                }
            }
        }
        return num;
    }

    private void dps(int i, int j, char[][] grid) {
        avail[i][j] = true;
        if(i > 0 && grid[i-1][j] == '1' && !avail[i-1][j]) dps(i-1, j, grid);
        if(j > 0 && grid[i][j-1] == '1' && !avail[i][j-1]) dps(i, j-1, grid);
        if(i < grid.length-1 && grid[i+1][j] == '1' && !avail[i+1][j]) dps(i+1, j, grid);
        if(j < grid[0].length-1 && grid[i][j+1] == '1' && !avail[i][j+1]) dps(i, j+1, grid);
    }
}
