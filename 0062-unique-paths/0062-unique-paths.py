import numpy as np

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = np.zeros((m, n), dtype = int)

        for i in range(0, m):
            for j in range(0, n):
                if(dp[i][j] == 0):
                    if(i == 0 or j == 0):
                        dp[i][j] = 1
                    else:
                        dp[i][j] = dp[i-1][j] + dp[i][j-1]

        return int(dp[m-1][n-1])
        