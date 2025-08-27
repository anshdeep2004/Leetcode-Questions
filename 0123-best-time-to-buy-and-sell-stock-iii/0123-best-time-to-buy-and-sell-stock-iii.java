// Memoization
class Solution {
    public int maxProf(int idx, int buy, int maxCap, int n, int[] prices, int[][][] dp) {
        if(idx == n) return 0;
        if(maxCap == 0) return 0;
        
        if(dp[idx][buy][maxCap] != -1) return dp[idx][buy][maxCap];

        // when we can buy a stock
        int profit = 0; 
        if(buy == 1) {
            profit = Math.max(-prices[idx] + maxProf(idx+1, 0, maxCap, n, prices, dp), 
                               maxProf(idx+1, 1, maxCap, n, prices, dp));
        }
        else {
            profit = Math.max(prices[idx] + maxProf(idx, 1, maxCap-1, n, prices, dp), 
                              maxProf(idx+1, 0, maxCap, n, prices, dp));
        }
        return dp[idx][buy][maxCap] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = 1;
        int[][][] dp = new int[n][2][3];

        for(int i=0; i<n; i++) {
            for(int j=0; j<2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return maxProf(0, buy, 2, n, prices, dp);
    }
}