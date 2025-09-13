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

//         return dp[0][-1+1];
//     }
// }


// Space optimisation
class Solution {
    public int lengthOfLIS(int[] nums) {
    int n = nums.length;
        int[] nextRow = new int[n+1];
        int[] currRow = new int[n+1];

        for(int idx=n-1; idx>=0; idx--) {
            for(int prevIdx=idx-1; prevIdx>=-1; prevIdx--) {
                int lenNotTake = 0 + nextRow[prevIdx+1];
                int lenTake = 0;
                if(prevIdx == -1 || nums[idx] > nums[prevIdx]) {
                    lenTake = 1 + nextRow[idx+1];
                }
                currRow[prevIdx+1] = Math.max(lenTake, lenNotTake);
            }
            nextRow = Arrays.copyOf(currRow, currRow.length);
        }

        return nextRow[-1+1]; // nextRow[0];
    }
}