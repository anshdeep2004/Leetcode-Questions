// Memoization
// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
//         int[][] dp = new int[m][n];
//         return paths(obstacleGrid, m-1, n-1, dp);
//     }
//     public int paths(int[][] grid, int m, int n, int[][] dp) {
//         if(m == 0 && n == 0) return 1;

//         if(m < 0 || n < 0) return 0;

//         if(grid[m][n] == 1) return 0;

//         if(dp[m][n] != 0) return dp[m][n];

//         return dp[m][n] = paths(grid, m-1, n, dp) + paths(grid, m, n-1, dp);
//     }
// }

// Tabulation
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else if(i == 0 || j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                 
            }
        }

        return dp[m-1][n-1];
    }
}