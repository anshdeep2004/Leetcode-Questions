class Solution:
    def isSubsetSum(self, arr: List[int], target) -> bool:
        n = len(arr)
        # dp = np.zeros((n + 1, target + 1), dtype = bool)
        dp = [[False for _ in range(target + 1)] for _ in range(n + 1)]

        # base case
        for i in range(0, n + 1):
            dp[i][0] = True

        for i in range(0, n + 1):
            for j in range(1, target + 1):
                take = False
                if(j >= arr[i-1]):
                    take = dp[i-1][j - arr[i-1]]
                notTake = dp[i-1][j]
                dp[i][j] = take | notTake
        return dp[n][target]

    def canPartition(self, nums: List[int]) -> bool:
        totalSum = 0
        for i in range(0, len(nums)):
            totalSum += nums[i]

        if totalSum % 2 != 0:
            return False
        
        return self.isSubsetSum(nums, totalSum // 2)

        