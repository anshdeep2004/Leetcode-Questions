// Memoization
// class Solution {
//     public int countSs(int n, int m, String s, String t, int[][] dp) {
//         if(m < 0) return 1;
//         if(n < 0) return 0;

//         if(dp[n][m] != -1) return dp[n][m];

//         if(s.charAt(n) == t.charAt(m)) {
//             return dp[n][m] = countSs(n-1, m-1, s, t, dp) + countSs(n-1, m, s, t, dp);
//         }
//         else {
//             return dp[n][m] = countSs(n-1, m, s, t, dp);
//         }
//     }
//     public int numDistinct(String s, String t) {
//         int n = s.length();
//         int m = t.length();
//         int[][] dp = new int[n][m];
//         for(int i=0; i<n; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         return countSs(n-1, m-1, s, t, dp);
//     }
// }

// Tabulation - shift everything by 1 as indexes can not be negative like above thebase cases have the negative value. 0 -> (n-1) becomes 1 -> n.
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            dp[i][0] = 1;
        }
        for(int j=1; j<=m; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}