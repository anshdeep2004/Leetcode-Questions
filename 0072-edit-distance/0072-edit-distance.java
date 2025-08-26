// Memoization
// class Solution {
//     public int minOps(int i, int j, String w1, String w2, int[][] dp) {
//         if(i < 0) {
//             return j+1;
//         }
//         if(j < 0) {
//             return i+1;
//         }

//         if(dp[i][j] != -1) return dp[i][j];

//         if(w1.charAt(i) == w2.charAt(j)) {
//             return dp[i][j] = minOps(i-1, j-1, w1, w2, dp);
//         }
//         else {
//             return dp[i][j] = 1 + Math.min(minOps(i, j-1, w1, w2, dp), Math.min(minOps(i-1, j, w1, w2, dp), minOps(i-1, j-1, w1, w2, dp)));
//             // minOps(i, j-1, w1, w2, dp) - insertion
//             // minOps(i-1, j, w1, w2, dp) - deletion
//             // minOps(i-1, j-1, w1, w2, dp) - replace
//         }
//     }

//     public int minDistance(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();;

//         int[][] dp = new int[n][m];
//         for(int i=0; i<n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return minOps(n-1, m-1, word1, word2, dp);
//     }
// }

// Tabulation
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();;

        int[][] dp = new int[n+1][m+1];
        
        // base cases
        for(int i=0; i<=n; i++) {
            dp[i][0] = i;
        }
        for(int j=1; j<=m; j++) {
            dp[0][j] = j;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }

        return dp[n][m];
    }
}