class Solution {
    public int[][] LCSArray(String st1, String st2) {
        int n = st1.length();
        int m = st2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (st1.charAt(i-1) == st2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp;
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = LCSArray(str1, str2);

        int i = n, j = m;
        StringBuilder ans = new StringBuilder();

        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                ans.append(str1.charAt(i-1));
                i--;
            } else {
                ans.append(str2.charAt(j-1));
                j--;
            }
        }

        // Add leftover chars from str1
        while (i > 0) {
            ans.append(str1.charAt(i-1));
            i--;
        }

        // Add leftover chars from str2
        while (j > 0) {
            ans.append(str2.charAt(j-1));
            j--;
        }

        return ans.reverse().toString();
    }
}
