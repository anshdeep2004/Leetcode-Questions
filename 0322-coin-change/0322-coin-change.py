class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # if amount == 0:
        #     return 0
        # coins.sort()
        # amt_left = amount
        # coin_count = 0
        # for coin in reversed(coins):
        #     if amt_left >= coin:
        #         temp = amt_left // coin
        #         coin_count += temp
        #         amt_left %= coin
        #     else:
        #         continue
        # if amt_left == 0:
        #     return coin_count
        # else:
        #     return -1

        ## above appeoach is wrong as it only considers some possibilities and ignores the possibility that if we do not take the biggest coind then also we can make the amount. Below approach is the DP approach that is perfect.

        n = len(coins)
        dp = [[0 for _ in range(amount + 1)] for _ in range(n + 1)]

        # base case
        for i in range(n):
            dp[i][0] = 0
        
        for j in range(amount + 1):
            if j % coins[0] == 0:
                dp[0][j] = j // coins[0]
            else:
                dp[0][j] = int(1e9)
        
        # DP for loops
        for i in range(1, n):
            for amt in range(1, amount + 1):
                take = int(1e9)
                if(amt >= coins[i]):
                    take = 1 + dp[i][amt - coins[i]]
                notTake = 0 + dp[i-1][amt]
                dp[i][amt] = min(take, notTake)

        if dp[n-1][amount] != int(1e9):
            return dp[n-1][amount]
        else:
            return -1