class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return allPaths(m-1, n-1, dp);
    }
    public int allPaths(int m, int n, int[][] dp) {
        if(m == 0 && n == 0) {
            return 1;
        }
        if(m < 0 || n < 0) {
            return 0;
        }
        if(dp[m][n] != 0) return dp[m][n];
        return dp[m][n] = allPaths(m-1, n, dp) + allPaths(m, n-1, dp);
    }
}