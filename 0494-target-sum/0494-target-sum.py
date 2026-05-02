# class Solution:
#     def findTargetSumWays(self, nums: List[int], target: int) -> int:
#         n = len(nums)
#         totalSum = sum(nums)
#         if (totalSum - target) % 2 != 0:
#             return 0
#         if target > totalSum:
#             return 0
#         s2 = (totalSum - target) // 2
#         dp = [[0 for _ in range(s2 + 1)] for _ in range(n)]

#         # base cases
#         for i in range(0, n):
#             dp[i][0] = 1
#         if nums[0] <= s2:
#             dp[0][nums[0]] = 1

#         # DP for loops
#         for i in range(1, n):
#             for j in range(1, s2 + 1):
#                 take = 0
#                 if j >= nums[i]:
#                     take = dp[i-1][j - nums[i]]
#                 notTake = dp[i-1][j]
#                 dp[i][j] = take + notTake
        
#         return dp[n-1][s2]

class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        n = len(nums)
        totalSum = sum(nums)

        if totalSum - target < 0 or (totalSum - target) % 2 != 0:
            return 0

        s2 = (totalSum - target) // 2

        dp = [[0 for _ in range(s2 + 1)] for _ in range(n)]

        # base case
        if nums[0] == 0:
            dp[0][0] = 2
        else:
            dp[0][0] = 1

        if nums[0] != 0 and nums[0] <= s2:
            dp[0][nums[0]] = 1

        for i in range(1, n):
            for j in range(0, s2 + 1):
                take = 0
                if nums[i] <= j:
                    take = dp[i - 1][j - nums[i]]

                notTake = dp[i - 1][j]

                dp[i][j] = take + notTake

        return dp[n - 1][s2]