class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = -1;
        }
        return robMoney(n-1, nums, dp);
    }
    public int robMoney(int ind, int[] nums, int[] dp) {
        if(ind == 0) return nums[0];
        if(ind < 0) return 0;

        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + robMoney(ind - 2, nums, dp);
        int nonPick = robMoney(ind - 1, nums, dp);

        return dp[ind] = Math.max(pick, nonPick);

    }
}