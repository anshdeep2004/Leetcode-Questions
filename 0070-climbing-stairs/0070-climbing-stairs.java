class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for(int i=0; i<=n; i++) {
            dp[i] = -1;
        }
        return stairClimb(n, dp);
    }
    public int stairClimb(int n, int[] dp) {
        if(n <= 1) return 1;
        if(dp[n] != -1) return dp[n];

        return dp[n] = stairClimb(n-1, dp) + stairClimb(n-2, dp);
    }
}