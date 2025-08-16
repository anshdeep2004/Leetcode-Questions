// Memoization
// class Solution {
//     public int lcs(int n, int m, String str1, String str2, int[][] dp) {
//         if(n < 0 || m < 0) return 0;
        
//         if(dp[n][m] != -1) return dp[n][m];

//         if(str1.charAt(n) == str2.charAt(m)) {
//             return dp[n][m] = 1 + lcs(n-1, m-1, str1, str2, dp);
//         }

//         else {
//             return dp[n][m] = Math.max(lcs(n-1, m, str1, str2, dp), lcs(n, m-1, str1, str2, dp));
//         }
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
//         int[][] dp = new int[n][m];
//         for(int i=0; i<n; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         return lcs(n-1, m-1, text1, text2, dp);
//     }
// }





// Memoization using shift used for Tabulation
// class Solution {
//     public int lcs(int n, int m, String str1, String str2, int[][] dp) {
//         if(n == 0 || m == 0) return 0;
        
//         if(dp[n][m] != -1) return dp[n][m];

//         if(str1.charAt(n-1) == str2.charAt(m-1)) {
//             return dp[n][m] = 1 + lcs(n-1, m-1, str1, str2, dp);
//         }

//         else {
//             return dp[n][m] = Math.max(lcs(n-1, m, str1, str2, dp), lcs(n, m-1, str1, str2, dp));
//         }
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
//         int[][] dp = new int[n+1][m+1];
//         for(int i=0; i<=n; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         return lcs(n, m, text1, text2, dp);
//     }
// }




// Tabulation using the shifted code (the reason being that in tabulation we have the dp array stired and it cannot have negative values so its important to shift the parameters).
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
//         int[][] dp = new int[n+1][m+1];
        
//         for(int i=0; i<=n; i++) {
//             dp[i][0] = 0;
//         }
//         for(int j=0; j<=m; j++) {
//             dp[0][j] = 0;
//         }

//         for(int i=1; i<=n; i++) {
//             for(int j=1; j<=m; j++) {
//                 if(text1.charAt(i-1) == text2.charAt(j-1)) {
//                     dp[i][j] = 1 + dp[i-1][j-1];
//                 }
//                 else {
//                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                 }
//             }
//         }
//         return dp[n][m];
//     }
// }




// Space optimisation - does not work that efficient
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        
        for(int i=0; i<=m; i++) {
            prev[i] = 0;
        }

        for(int i=1; i<=n; i++) {
            curr = new int[m+1];
            for(int j=1; j<=m; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    curr[j] = 1 + prev[j-1];
                }
                else {
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}