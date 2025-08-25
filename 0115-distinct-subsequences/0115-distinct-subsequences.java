// Memoization
class Solution {
    public int countSs(int n, int m, String s, String t, int[][] dp) {
        if(m < 0) return 1;
        if(n < 0) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        if(s.charAt(n) == t.charAt(m)) {
            return dp[n][m] = countSs(n-1, m-1, s, t, dp) + countSs(n-1, m, s, t, dp);
        }
        else {
            return dp[n][m] = countSs(n-1, m, s, t, dp);
        }
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return countSs(n-1, m-1, s, t, dp);
    }
}