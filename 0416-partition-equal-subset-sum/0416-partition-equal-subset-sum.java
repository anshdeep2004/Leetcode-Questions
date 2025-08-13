// The question can be solved using the logic that if there are 2 subsets then sum of each subset is (total sum of array) / 2. like in the given example [1,5,11,5] the total sum = 22 and if they are devided into 2 subsets then each will have a sum = 11. So the question reduces to find a subset in the array with sum = total / 2 of subset sum equals k. 

class Solution {
    public boolean subsetSumEqualsK(int[] nums, int k) {
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][k+1];

        for(int i=0; i<=n; i++) {
            dp[i][0] = true;
        }

        for(int i=1; i<=n; i++) {
            for(int target=1; target<=k; target++) {
                boolean notTake = dp[i-1][target];
                boolean take = false;
                if(target >= nums[i-1]) {
                    take = dp[i-1][target - nums[i-1]];
                }
                dp[i][target] = notTake | take;
            }
        }
        return dp[n][k];
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i=0; i<nums.length; i++) {
            totalSum += nums[i];
        }
        if(totalSum % 2 != 0) return false;
        
        return subsetSumEqualsK(nums, totalSum/2);
    }
}