// Memoization
// class Solution {
//     public int maxProf(int idx, int buy, int n, int[] prices, int[][] dp) {
//         if(idx == n) return 0;
        
//         if(dp[idx][buy] != -1) return dp[idx][buy];

//         // when we can buy a stock
//         int profit = 0; 
//         if(buy == 1) {
//             profit = Math.max(-prices[idx] + maxProf(idx+1, 0, n, prices, dp), 
//                                maxProf(idx+1, 1, n, prices, dp));
//         }
//         else {
//             profit = Math.max(prices[idx] + maxProf(idx, 1, n, prices, dp), 
//                               maxProf(idx+1, 0, n, prices, dp));
//         }
//         return dp[idx][buy] = profit;
//     }
//
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int buy = 1;
//         int[][] dp = new int[n][2];

//         for(int i=0; i<n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return maxProf(0, buy, n, prices, dp);
//     }
// }




// Tabulation
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = 1;
        int[][] dp = new int[n+1][2];

        dp[n][0] = dp[n][1] = 0;

        for(int i=n-1; i>=0; i--) {
            for(int b=0; b<2; b++) {
                int profit = 0;
                if(b == 1) {
                    profit = Math.max(-prices[i] + dp[i+1][0], 0 + dp[i+1][1]);
                }
                else {
                    profit = Math.max(prices[i] + dp[i+1][1], 0 + dp[i+1][0]);
                }
                dp[i][b] = profit;
            }
        }

        return dp[0][1];
    }
}