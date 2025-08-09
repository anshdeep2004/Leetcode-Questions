// Memoization
// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int[][] dp = new int[m][n];
//         return minPath(grid, m-1, n-1, dp);
//     }
//     public int minPath(int[][] grid, int m, int n, int[][] dp) {
//         if(m == 0 && n == 0) {
//             return grid[0][0];
//         }
//         if(m < 0 || n < 0) {
//             return (int) 1e9;
//         }

//         if(dp[m][n] != 0) {
//             return dp[m][n];
//         }
//         int up = grid[m][n] + minPath(grid, m-1, n, dp);
//         int left = grid[m][n] + minPath(grid, m, n-1, dp);

//         return dp[m][n] = Math.min(up, left);
//     }
// }

// Tabulation
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else {
                    int up = (int) 1e9;
                    int left = (int) 1e9;
                    if(i > 0) up = grid[i][j] + dp[i-1][j];
                    if(j > 0) left = grid[i][j] + dp[i][j-1];
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}