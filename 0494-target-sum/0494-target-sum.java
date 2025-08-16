// Memoization
class Solution {
    public void numTarSumWays(int idx, int[] nums, int target, int[] count, int[][] dp) {
        if (target < -1000 || target > 1000) return;
        
        if(idx < 0) {
            if(target == 0) count[0]++;
            return ;
        }
        if(dp[idx][target + 1000] != -1) {
            count[0] += dp[idx][target + 1000];
            return ;
        }

        int beforeCount = count[0];
        numTarSumWays(idx-1, nums, target - nums[idx], count, dp);
        numTarSumWays(idx-1, nums, target + nums[idx], count, dp);
        int ways = count[0] - beforeCount;

        dp[idx][target + 1000] = ways;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[] count = new int[1];
        int[][] dp = new int[n][2001];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        numTarSumWays(n-1, nums, target, count, dp);
        return count[0];
    }
}

// class Solution {
//     public void numTarSumWays(int idx, int[] nums, int target, int[] count, Integer[][] dp) {
//         if (idx < 0) {
//             if (target == 0) count[0]++;
//             return;
//         }

//         // Memoization check
//         if (dp[idx][target + 1000] != null) {
//             count[0] += dp[idx][target + 1000]; // reuse cached result
//             return;
//         }

//         int before = count[0];
//         numTarSumWays(idx - 1, nums, target - nums[idx], count, dp);
//         numTarSumWays(idx - 1, nums, target + nums[idx], count, dp);
//         int ways = count[0] - before;

//         dp[idx][target + 1000] = ways; // store result
//     }

//     public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length;
//         int[] count = new int[1];
//         Integer[][] dp = new Integer[n][2001]; // memo table

//         numTarSumWays(n - 1, nums, target, count, dp);
//         return count[0];
//     }
// }
