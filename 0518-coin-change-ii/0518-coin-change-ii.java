// this question is same as Coin Change 1. There we wanted the minimum number of coins to make the amount and here we want the number of ways in whic we can make the amount.

// Memoization
class Solution {
    public int numWays(int idx, int[] coins, int amt, int[][] dp) {
        if(amt == 0) return 1;
        if(idx == 0) {
            if(amt % coins[idx] == 0) return 1;
            else return 0;
        }

        if(dp[idx][amt] != -1) return dp[idx][amt];
        int notTake = numWays(idx-1, coins, amt, dp);
        int take = 0;
        if(coins[idx] <= amt) {
            take = numWays(idx, coins, amt - coins[idx], dp);
        }

        return dp[idx][amt] = take + notTake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return numWays(n-1, coins, amount, dp);
    }
}