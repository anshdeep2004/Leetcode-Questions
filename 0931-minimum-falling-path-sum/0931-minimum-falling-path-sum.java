// Memoization - Time limit exceed
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int[][] dp = new int[m][n];
//         int minSum = Integer.MAX_VALUE;
//         for (int col = 0; col < n; col++) {
//             minSum = Math.min(minSum, minPath(matrix, m - 1, col, dp));
//         }
//         return minSum;
//     }
//     public int minPath(int[][] mat, int i, int j, int[][] dp) {
//         if(j < 0 || j >= mat[0].length) {
//             return (int) 1e9;
//         }
//         if(i == 0) {
//             return mat[0][j];
//         }
//         if(dp[i][j] != 0) {
//             return dp[i][j];
//         }
        
//         int up = mat[i][j] + minPath(mat, i-1, j, dp);
//         int upLeft = mat[i][j] + minPath(mat, i-1, j-1, dp);
//         int upRight = mat[i][j] + minPath(mat, i-1, j+1, dp);
//         return dp[i][j] = Math.min(up, Math.min(upLeft, upRight));
//     }
//}

// Tabulation
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int minSum = (int) 1e9;
        
        for(int i=0; i<n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for(int i=1; i<m; i++) {
            for(int j=0; j<n; j++) {
                int up = (int) 1e9;
                int upLeft = (int) 1e9;
                int upRight = (int) 1e9;
                up = matrix[i][j] + dp[i-1][j];
                if(j > 0) upLeft = matrix[i][j] + dp[i-1][j-1];
                if(j < n-1) upRight = matrix[i][j] + dp[i-1][j+1];
                dp[i][j] = Math.min(up, Math.min(upLeft, upRight));
            }
        }
        for(int i=0; i<n; i++) {
            minSum = Math.min(minSum, dp[m-1][i]);
        }
        return minSum;
    }
}