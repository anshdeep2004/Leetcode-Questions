// class Solution {
//     public int numTrees(int n) {
//         if(n < 2) return 1;
//         if(n == 2) return 2;

//         int unBST = 0;

//         for(int i=1; i<=n; i++) {
//             unBST += numTrees(i - 1) * numTrees(n - i);
//         }

//         return unBST;
//     }
// }

// Tabulation
class Solution {
    public int numTrees(int n) {
        if(n < 2) return 1;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;

        for(int j=3; j<=n; j++) {
            int unBST = 0;
            for(int i=1; i<=j; i++) {
                unBST += dp[i - 1] * dp[j - i];
            }
            dp[j] = unBST;
        }

        return dp[n];
    }
}