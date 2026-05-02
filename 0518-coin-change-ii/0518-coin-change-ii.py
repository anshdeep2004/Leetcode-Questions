class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        dp = [[0 for _ in range(amount + 1)] for _ in range(n)]

        # base cases
        for i in range(n):
            dp[i][0] = 1
        for j in range(amount + 1):
            if j % coins[0] == 0:
                dp[0][j] = 1
        
        # DP for loops
        for i in range(1, n):
            for j in range(1, amount + 1):
                take = 0
                if amount >= coins[i]:
                    take = dp[i][j - coins[i]]
                notTake = dp[i-1][j]
                dp[i][j] = take + notTake
        return dp[n-1][amount]