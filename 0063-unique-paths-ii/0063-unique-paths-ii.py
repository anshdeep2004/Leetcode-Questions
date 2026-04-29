import numpy as np

class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])

        dp = np.zeros((m, n))
        for i in range(0, m):
            if(obstacleGrid[i][0] == 1):
                break
            else:
                dp[i][0] = 1

        for j in range(0, n):
            if(obstacleGrid[0][j] == 1):
                break
            else:
                dp[0][j] = 1

        for i in range(1, m):
            for j in range(1, n):
                if(obstacleGrid[i][j] != 1 and dp[i][j] == 0):
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]

        return int(dp[m-1][n-1])
        