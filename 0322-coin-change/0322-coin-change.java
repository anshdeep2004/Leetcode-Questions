// Memoization
// class Solution {
//     public int numCoins(int idx, int[] coins, int amt, int[][] dp) {
//         if(amt == 0) return 0;
//         if(idx == 0) {
//             if(amt % coins[idx] == 0) return amt/coins[idx];
//             else return (int) 1e9;
//         }
//         if(dp[idx][amt] != -1) return dp[idx][amt];
//         int notTake = 0 + numCoins(idx-1, coins, amt, dp);
//         int take = (int) 1e9;
//         if(coins[idx] <= amt) {
//             take = 1 + numCoins(idx, coins, amt - coins[idx], dp);
//         }

//         return dp[idx][amt] = Math.min(notTake, take);
//     }
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int[][] dp = new int[n][amount + 1];
//         for(int i=0; i<n; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         int coinNums = numCoins(n-1, coins, amount, dp);
//         if(coinNums == (int) 1e9) return -1;
//         return coinNums;
//     }
// }

// Tabulation
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        for(int i=0; i<n; i++) {
            dp[i][0] = 0;
        }
        for(int i=0; i<=amount; i++) {
            if(i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = (int) 1e9;
        }

        for(int i=1; i<n; i++) {
            for(int amt=1; amt<=amount; amt++) {
                int notTake = 0 + dp[i - 1][amt];
                int take = (int) 1e9;
                if(coins[i] <= amt) {
                    take = 1 + dp[i][amt - coins[i]];
                }
                dp[i][amt] = Math.min(take, notTake);
            }
        }
        int ans = dp[n-1][amount];
        if(ans == (int) 1e9) return -1;
        return ans;
    }
}