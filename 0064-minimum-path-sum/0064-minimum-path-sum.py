import numpy as np

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dp = np.zeros((m, n))

        for i in range(0, m):
            for j in range(0, n):
                dp[i][j] = grid[i][j]
                if i > 0 and j == 0:
                    dp[i][j] += dp[i-1][j]
                elif i == 0 and j > 0:
                    dp[i][j] += dp[i][j-1]
                elif i > 0 and j > 0:
                    dp[i][j] += min(dp[i-1][j], dp[i][j-1])

        return int(dp[m-1][n-1])