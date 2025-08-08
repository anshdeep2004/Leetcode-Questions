class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];
        return paths(obstacleGrid, m-1, n-1, dp);
    }
    public int paths(int[][] grid, int m, int n, int[][] dp) {
        if(m == 0 && n == 0) return 1;
        if(dp[m][n] != 0 && grid[m][n] != 1) return dp[m][n];
        int up = 0;
        int left = 0;
        if(m-1 >= 0 && grid[m-1][n] != 1) {
            up = paths(grid, m-1, n, dp);
        }
        if(n-1 >= 0 && grid[m][n-1] != 1) {
            left = paths(grid, m, n-1, dp);
        }
        return dp[m][n] = up + left;
    }
}