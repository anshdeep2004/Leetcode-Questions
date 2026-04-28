class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if(n == 1):
            return nums[0]
        dp = [nums[0]]

        for i in range(1, n-1):
            pick = nums[i]
            if(i > 1):
                pick += dp[i-2]
            notPick = dp[i-1]

            dp.append(max(pick, notPick))

        max1 = dp[n-2]

        dp = [nums[1]]

        for i in range(2, n):
            pick = nums[i]
            if(i > 2):
                pick += dp[i-3]
            notPick = dp[i-2]

            dp.append(max(pick, notPick))

        max2 = dp[n-2]

        return max(max1, max2)