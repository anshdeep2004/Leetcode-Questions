// class Solution {
//     public int countSquares(int[][] A) {
//         if (A == null || A.length == 0 || A[0].length == 0) {
//             return 0;
//         }

//         int m = A.length;
//         int n = A[0].length;
//         int res = 0;

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (A[i][j] == 1 && i > 0 && j > 0) {
//                     A[i][j] = Math.min(
//                         A[i - 1][j - 1],
//                         Math.min(A[i - 1][j], A[i][j - 1])
//                     ) + 1;
//                 }
//                 res += A[i][j];
//             }
//         }

//         return res;
//     }
// }


class Solution {
    public int countSquares(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int[][] dp = new int[n][m];
        int ans = 0;

        for(int i=0; i<n; i++) {
            dp[i][0] = A[i][0];
            ans += dp[i][0];
        }
        for(int j=1; j<m; j++) {
            dp[0][j] = A[0][j];
            ans += dp[0][j];
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(A[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    ans += dp[i][j];
                }
            }
        }

        return ans;
    }
}