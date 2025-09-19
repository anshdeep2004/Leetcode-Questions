// Memoization
// class Solution {
//     public int f(int i, int j, int[] newNums, int[][] dp) {
//         if(i > j) return 0;
//         if(dp[i][j] != -1) return dp[i][j];
//         int max = 0;

//         for(int k=i; k<=j; k++) {
//             int coins = newNums[i-1] * newNums[k] * newNums[j+1] + f(i, k-1, newNums, dp) + f(k+1, j, newNums, dp);
//             max = Math.max(max, coins);
//         }
//         return max;
//     }
//     public int maxCoins(int[] nums) {
//         int n = nums.length;
//         int[] newNums = new int[n+2];
//         newNums[0] = 1;
//         newNums[n+1] = 1;
//         for(int i=0; i<n; i++) {
//             newNums[i+1] = nums[i];
//         }
//         int[][] dp = new int[n+1][n+1];
//         for(int i=0; i<n+1; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return f(1, n, newNums, dp);
//     }
// }



// Tabulation
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = 1;
        newNums[n+1] = 1;
        for(int i=0; i<n; i++) {
            newNums[i+1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];

        // Base cases are not required as already all the values of the dp array is 0.

        for(int i=n; i>=1; i--) {
            for(int j=1; j<=n; j++) {
                if(i > j) continue ;
                int max = 0;
                for(int k=i; k<=j; k++) {
                    int coins = newNums[i-1] * newNums[k] * newNums[j+1] + dp[i][k-1] + dp[k+1][j];
                    max = Math.max(max, coins);
                }
                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }
}