// Memoization
class Solution {
    public int numCoins(int idx, int[] coins, int amt, int[][] dp) {
        if(amt == 0) return 0;
        if(idx == 0) {
            if(amt % coins[idx] == 0) return amt/coins[idx];
            else return (int) 1e9;
        }
        if(dp[idx][amt] != -1) return dp[idx][amt];
        int notTake = 0 + numCoins(idx-1, coins, amt, dp);
        int take = (int) 1e9;
        if(coins[idx] <= amt) {
            take = 1 + numCoins(idx, coins, amt - coins[idx], dp);
        }

        return dp[idx][amt] = Math.min(notTake, take);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int coinNums = numCoins(n-1, coins, amount, dp);
        if(coinNums == (int) 1e9) return -1;
        return coinNums;
    }
}