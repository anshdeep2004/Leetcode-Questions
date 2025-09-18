// Memoization
// class Solution {
//     public int f(int idx, int prevIdx, int n, int[] nums, int [][] dp) {
//         if(idx == n) return 0;
        
//         if(dp[idx][prevIdx+1] != -1) return dp[idx][prevIdx+1];

//         int lenNotTake = 0 + f(idx+1, prevIdx, n, nums, dp);
//         int lenTake = 0;
//         if(prevIdx == -1 || nums[idx] > nums[prevIdx]) {
//             lenTake = 1 + f(idx+1, idx, n, nums, dp);
//         }

//         return dp[idx][prevIdx+1] = Math.max(lenTake, lenNotTake);
//     }

//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n][n+1];
//         for(int i=0; i<n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return f(0, -1, n, nums, dp);
//     }
// }


// Tabulation
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n+1][n+1];

//         for(int idx=n-1; idx>=0; idx--) {
//             for(int prevIdx=idx-1; prevIdx>=-1; prevIdx--) {
//                 int lenNotTake = 0 + dp[idx+1][prevIdx+1];
//                 int lenTake = 0;
//                 if(prevIdx == -1 || nums[idx] > nums[prevIdx]) {
//                     lenTake = 1 + dp[idx+1][idx+1];
//                 }
//                 dp[idx][prevIdx+1] = Math.max(lenTake, lenNotTake);
//             }
//         }

//         return dp[0][-1+1]; // nextRow[0];
//     }
// }


// Space optimisation
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//     int n = nums.length;
//         int[] nextRow = new int[n+1];
//         int[] currRow = new int[n+1];

//         for(int idx=n-1; idx>=0; idx--) {
//             for(int prevIdx=idx-1; prevIdx>=-1; prevIdx--) {
//                 int lenNotTake = 0 + nextRow[prevIdx+1];
//                 int lenTake = 0;
//                 if(prevIdx == -1 || nums[idx] > nums[prevIdx]) {
//                     lenTake = 1 + nextRow[idx+1];
//                 }
//                 currRow[prevIdx+1] = Math.max(lenTake, lenNotTake);
//             }
//             nextRow = Arrays.copyOf(currRow, currRow.length);
//         }

//         return nextRow[-1+1]; // nextRow[0];
//     }
// }


// Another tabulation approach
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for(int i=0; i<n; i++) {
            for(int prev=0; prev<i; prev++) {
                if(nums[i] > nums[prev]) {
                    dp[i] = Math.max(dp[i], dp[prev] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

// Code For largest bitonic subsequnce 
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp1 = new int[n];
//         int[] dp2 = new int[n];
//         int[] bitonic = new int[n];
//         Arrays.fill(dp1, 1);
//         Arrays.fill(dp2, 1);
//         int max = 1;

//         for(int i=0; i<n; i++) {
//             for(int prev=0; prev<i; prev++) {
//                 if(nums[i] > nums[prev]) {
//                     dp1[i] = Math.max(dp1[i], dp1[prev] + 1);
//                 }
//             }

//             for(int k=n-1; k>i; k--) {
//                 if(nums[i] > nums[j]) {
//                     dp2[i] = Math.max(dp2[i], dp2[k] + 1);
//                 }
//             }
//             bitonic[i] = dp1[i] + dp2[i] - 1;
//             max = Math.max(max, dp1[i] + dp2[i] - 1);
//         }

//         return max;
//     }
// }