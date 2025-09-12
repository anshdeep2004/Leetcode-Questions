// Memoization
// class Solution {
//     public int maxProf(int idx, int buy, int maxCap, int n, int[] prices, int[][][] dp) {
//         if(idx == n) return 0;
//         if(maxCap == 0) return 0;
        
//         if(dp[idx][buy][maxCap] != -1) return dp[idx][buy][maxCap];

//         // when we can buy a stock
//         int profit = 0; 
//         if(buy == 1) {
//             profit = Math.max(-prices[idx] + maxProf(idx+1, 0, maxCap, n, prices, dp), 
//                                maxProf(idx+1, 1, maxCap, n, prices, dp));
//         }
//         else {
//             profit = Math.max(prices[idx] + maxProf(idx, 1, maxCap-1, n, prices, dp), 
//                               maxProf(idx+1, 0, maxCap, n, prices, dp));
//         }
//         return dp[idx][buy][maxCap] = profit;
//     }

//     public int maxProfit(int k, int[] prices) {
//         int n = prices.length;
//         int buy = 1;
//         int[][][] dp = new int[n][2][k+1];

//         for(int i=0; i<n; i++) {
//             for(int j=0; j<2; j++) {
//                 Arrays.fill(dp[i][j], -1);
//             }
//         }

//         return maxProf(0, buy, k, n, prices, dp);
//     }
// }

// Tabulation
class Solution {
    public int maxProfit(int l, int[] prices) {
        int n = prices.length;
        int buy = 1;
        int[][][] dp = new int[n+1][2][l+1];

        // Base cases - base cases we have written makes sence but when we know that iniyially in an array every element is 0 only so no need to write the base cases as it is assigning the value to 0 only.
        // for(int i=0; i<2; i++) {
        //     for(int j=0; j<3; j++) {
        //         dp[n][i][j] = 0;
        //     }
        // }

        // for(int i=0; i<=n; i++) {
        //     for(int j=0; j<2; j++) {
        //         dp[i][j][0] = 0;
        //     }
        // }

        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<2; j++) {
                for(int k=1; k<=l; k++) {
                    if(j == 1) {
                        dp[i][j][k] = Math.max(-prices[i] + dp[i+1][0][k], dp[i+1][1][k]);
                    }
                    else {
                        dp[i][j][k] = Math.max(prices[i] + dp[i+1][1][k-1], dp[i+1][0][k]);
                    }
                }
            }
        }

        return dp[0][1][l];
    }
}