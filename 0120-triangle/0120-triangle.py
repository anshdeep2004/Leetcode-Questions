import numpy as np

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = [[triangle[0][0]]]

        for i in range(1, len(triangle)):
            temp = np.zeros((len(triangle[i])))
            for j in range(0, len(triangle[i])):
                temp[j] = triangle[i][j]
                if j == 0:
                    temp[j] += dp[i-1][j]
                elif j == len(triangle[i-1]):
                    temp[j] += dp[i-1][j-1]
                else:
                    temp[j] += min(dp[i-1][j], dp[i-1][j-1])
            dp.append(temp)

        minAns = dp[-1][0]
        for num in dp[-1]:
            minAns = min(minAns, num)
        
        return int(minAns)
        