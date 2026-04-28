class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [nums[0]]

        for i in range(1, n):
            pick = nums[i]
            if i > 1:
                pick += dp[i-2]
            nonPick = dp[i-1]

            dp.append(max(pick, nonPick))

        return dp[n-1]