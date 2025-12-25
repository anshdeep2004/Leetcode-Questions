class Solution {
    // Solution uses logest increasing subsequence. If you know longest increasing subsequence then just here in this question the change is that there we were taking LIS of on string here we have to consider all the strings in array strs at the same time to get the maximum columns that we can keep and then subtract that with total columns to delete minimum number of columns.
    
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int[] dp = new int[m];
        int maxKeep = 1;

        for (int j = 0; j < m; j++) {
            dp[j] = 1; // each column alone is valid

            for (int i = 0; i < j; i++) {
                boolean valid = true;

                for (int k = 0; k < n; k++) {
                    if (strs[k].charAt(i) > strs[k].charAt(j)) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }

            maxKeep = Math.max(maxKeep, dp[j]);
        }

        return m - maxKeep;
    }
}